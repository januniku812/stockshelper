import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

class StocksFileEditor{
    StocksFileEditor() throws FileNotFoundException {
    }

    public static void run() throws IOException{
        // opening the xlsx with the stock tickers to be read in the first column
        File file = new File("C:\\Users\\jshar\\Ideaproject2\\stockshelper\\src\\main\\java\\highrisktradesinput.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator < Row > rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //For each row, iterate through each columns
            Iterator < Cell > cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.println(cell.getColumnIndex());
                String stock_ticker  = sheet.getRow(cell.getRowIndex()).getCell(0).getStringCellValue();
                if (cell.getColumnIndex() == 0 && cell.getRowIndex() > 0)  {
                    System.out.println("MADE IT");
                    // take each value in each cell to find the curretn sotck ticker value as an array to feed the HomeworkHelper function
                    ArrayList<String> array = new ArrayList<>();
                    array.add(stock_ticker + " stock");
                    System.out.println("STOCK PRICE: " + WebCrawler.HomeworkHelper(array));
                    // creating a new cell in next column for each of the corresponding newfound ticker values
                    row.createCell(1)
                    row.getCell(1).setCellValue( WebCrawler.HomeworkHelper(array).replace("<", "").replace(">", ""));
                }
            }
        }
        fileInputStream.close();
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\jshar\\Ideaproject2\\stockshelper\\src\\main\\java\\slp_output.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}

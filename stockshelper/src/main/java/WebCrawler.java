import java.io.IOException;
import java.lang.StringIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class WebCrawler {
    public static String HomeworkHelper(ArrayList<String> StringArray) throws IOException {
        for(int i = 0; i < StringArray.size(); i++ ){
            //String [] StringArray = {"when was 9/11", "who was bill gates"}
            String question2 = StringArray.get(i);
            String question = question2.substring(0, 1).toUpperCase() + question2.substring(1, question2.length());
            String NewURL = question.replace(" ", "+");
            String URL = "https://www.google.com/search?q=" + NewURL;
            Document document = Jsoup.connect(URL).get();
            //cutting out extra parts and getting just the answer
            if (document.select("div.Z0LcW.XcVN5d") != null){
                try {
                    Elements answer = document.select("div.Z0LcW.XcVN5d");
                    String answerToString = answer.toString();
                    int index = answerToString.indexOf(">");
                    String FinalAnswer2 = answerToString.substring(index+3, answerToString.length()-6);
                    String FinalAnswer = FinalAnswer2.replace("&nbsp;"," ");
                    return FinalAnswer;
                }
                catch(StringIndexOutOfBoundsException ex) {
                    try{
                        Elements answer2 = document.select("span.hgKElc");
                        String answer2ToString = answer2.toString();
                        String FinalAnswer2 = answer2ToString;
                        String FinalAnswer3 = FinalAnswer2.replace("<b>", "");
                        String FinalAnswer4 = FinalAnswer3.replace("</b>", "");
                        String FinalAnswer5 = FinalAnswer4.replace("<", "");
                        String FinalAnswer6 = FinalAnswer5.substring(20, FinalAnswer5.length()-6);
                        return FinalAnswer6;
                    }
                    catch(StringIndexOutOfBoundsException e){
                        try {
                            Elements answer2 = document.select("div.ayqGOc.kno-fb-ctx.KBXm4e");
                            String answer2ToString = answer2.toString();
                            String FinalAnswer2 = answer2ToString;
                            String FinalAnswer3 = FinalAnswer2.replace("<b>", "");
                            String FinalAnswer4 = FinalAnswer3.replace("</b>", "");
                            String FinalAnswer5 = FinalAnswer4.replace("<", "");
                            String FinalAnswer6 = FinalAnswer5.replace("&nbsp;"," ");
                            int index = FinalAnswer6.indexOf(">");
                            String FinalAnswer7 =  FinalAnswer6.substring(index+15, FinalAnswer6.length()-5);
                            return FinalAnswer7;
                        }
                        catch(StringIndexOutOfBoundsException exception){
                            try{
                                Elements answer3 = document.select("pre#tw-target-rmn.tw-data-text.tw-text-small.tw-ta");
                                String answer3ToString = answer3.toString();
                                String FinalAnswer1 = answer3ToString;
                                int index = FinalAnswer1.indexOf(">");
                                String FinalAnswer2 =  FinalAnswer1.substring(index+6, FinalAnswer1.length()-12);
                                //String FinalAnswer3 = FinalAnswer2.replace("<span", "");
                                //String FinalAnswer4 = FinalAnswer3.replace("</span>", "");
                                String FinalAnswer5 = FinalAnswer2.replace("<", "");
                                String FinalAnswer6 = FinalAnswer5.replace(">","");
                                return FinalAnswer6;
                            }
                            catch(StringIndexOutOfBoundsException exception1){
                                try{
                                    Elements answer3 = document.select("pre#tw-target-text.tw-data-text.tw-text-large.XcVN5d.tw-ta");
                                    String answer3ToString = answer3.toString();
                                    String FinalAnswer1 = answer3ToString;
                                    int index = FinalAnswer1.indexOf(">");
                                    String FinalAnswer2 =  FinalAnswer1.substring(index+6, FinalAnswer1.length()-12);
                                    //String FinalAnswer3 = FinalAnswer2.replace("<span", "");
                                    //String FinalAnswer4 = FinalAnswer3.replace("</span>", "");
                                    String FinalAnswer5 = FinalAnswer2.replace("<", "");
                                    String FinalAnswer6 = FinalAnswer5.replace(">","");
                                    String FinalAnswer7 = FinalAnswer6.replace("ệ","e");
                                    String FinalAnswer8 = FinalAnswer7.replace("ǐ","i");
                                    String FinalAnswer9 = FinalAnswer8.replace("ǎ","a");
                                    String FinalAnswer10 = FinalAnswer9.replace("ǒ","e");
                                    return FinalAnswer10;
                                }
                                catch(StringIndexOutOfBoundsException exception2){
                                    try{
                                        Elements answer1 = document.select("div.BRoiGe");
                                        String answer2 = answer1.toString();
                                        int index = answer2.indexOf(">");
                                        String FinalAnswer2 =  answer2.substring(index+3, answer2.length()-6);
                                        return FinalAnswer2;
                                    }
                                    catch(StringIndexOutOfBoundsException exception3) {
                                        try{
                                            String question3 = StringArray.get(i);
                                            String mathQuestion = question3.replace("+","%2B");
                                            String mathQuestionDiv= mathQuestion.replace("/", "%2F");
                                            String mathQuestion2 = mathQuestionDiv.replace(" ","+");
                                            String mathQuestion3 = "https://www.google.com/search?q="+mathQuestion2;
                                            Document mathDocument = Jsoup.connect(mathQuestion3).get();
                                            Elements answer1 = mathDocument.select("span#cwos.qv3Wpe");
                                            String answer2 = answer1.toString();
                                            int index = answer2.indexOf(">");
                                            String FinalAnswer2 =  answer2.substring(index+2, answer2.length()-8);
                                            return FinalAnswer2;
                                        }
                                        catch(StringIndexOutOfBoundsException exception5){
                                            try{
                                                Elements answer1 = document.select("span.IsqQVc.NprOob.XcVN5d.wT3VGc");
                                                String answer1_string = answer1.toString();
                                                String substring = answer1_string.substring(answer1_string.indexOf(">")+1, answer1_string.indexOf("</span>"));
                                                return substring;
                                            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                                                try {
                                                    Elements answer1 = document.select("span.IsqQVc.NprOob.wT3VGc");
                                                    String answer1_string = answer1.toString();
                                                    String substring = answer1_string.substring(answer1_string.indexOf(">")+1, answer1_string.indexOf("</span>"));
                                                    return substring;
                                                } catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException1) {
                                                    System.out.println(question + "?");
                                                    System.out.println("we could not find a featured answer for this, we suggest you check it out yourself");
                                                }
                                            }
                                        }
                                    }
                                }


                            }

                        }
                    }
                }
            }

        }
        return "No answer found";
    }






//span class = hgKElc
//div class="Z0LcW XcVN5d AZCkJd"
//pre#tw-target-text.tw-data-text.tw-text-large.XcVN5d.tw-ta

    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter questions");

        String questions = myObj.nextLine();  // Read user input
        ArrayList<String> splitQuestions = new ArrayList<>();
        for(String question: questions.split("\\?")){
            splitQuestions.add(question);
        }
        HomeworkHelper(splitQuestions);
    }
}








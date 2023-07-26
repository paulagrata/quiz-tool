import java.util.ArrayList;
import java.util.Scanner;


/**
 * the main class 
 * prints the welcome banner
 * asks user for file name
 * creates array list of questions for the file
 * the question array list is sent to the QuestionReader that splits the file and reads the data
 * the question array list is sent to the quizzer that will go through questions with user
 * creates array list for printing questions to XML
 * the question array list and new file name is sent to the QuestionPrinter printQuestionsToXML
 * @author paula
 */

public class OOQuizTool {
    public static void main(String[] args){
        ArrayList<Question> qList = new ArrayList<Question>();
        Quizzer quiz = new Quizzer();                                   
        Scanner sc = new Scanner(System.in);
        String fname;
        System.out.println("***********************************************************");
        System.out.println("             Object-Oriented Theory Quiz Tool              ");
        System.out.println("***********************************************************\n");
        System.out.print("Enter Question File Name: ");                                             //asks user for file name
        fname = sc.next();                                                                      
        qList = QuestionReader.readQuestionsFromTextFile(fname);                                    //creates question list
        quiz.quiz(qList);                                                                           //sends list to quizzer
        ArrayList<Question> printXML = QuestionPrinter.printQuestionsToXML(qList,"questions.xml");  //prints list to xml
        sc.close();
    }
}

import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.File;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;

/**
 * a view class that has functions for printing a question as part of a quiz and for printing all the questions 
 * and their answers both to the screen and to an xml file
 * 
 * printQuestion - prints a single question at a time and the answer choices
 * printQuestionsAndAnswers - prints every single question in the question list with the correct answer
 * printQuestionsToXML - prints the question list to XML
 * @author paula
 */

public class QuestionPrinter {

     public static void printQuestion(Question qList) {
                    System.out.printf("\n%s\n",qList.getChoiceQuestion());
                    System.out.printf("a.\t%s\n",qList.getChoice("a"));
                    System.out.printf("b.\t%s\n",qList.getChoice("b"));
                    System.out.printf("c.\t%s\n",qList.getChoice("c"));
                    System.out.printf("d.\t%s\n",qList.getChoice("d"));
        }
    

    public static void printQuestionsAndAnswers(ArrayList<Question> qList) {
        for (Question q:qList){
            System.out.printf("\nq:\t%s\n",q.getChoiceQuestion());
            System.out.printf("%s:\t%s\n",q.getAnswer(),q.getChoice(q.getAnswer()));
        }
    }


	public static ArrayList<Question> printQuestionsToXML(ArrayList<Question> qList, String fname) {            //i was not sure if calling this 'static ArrayList<Question>' was correct, 
		try {                                                                                                   //i was getting an error, and one of the 'quickfix' options was to do this and it worked.
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fname))));   
			enc.writeObject(qList);
			enc.close();
			return qList;
		} catch (Exception ex) {
			return null;
		}
	}



}


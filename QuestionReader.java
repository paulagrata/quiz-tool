import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * a model class that reads the questions from a text file
 * choiceQuestion - question quizzer is asking
 * choiceLetter -   letter of choice answer option
 * choiceText - question answer choice 
 * answer - correct answer to question
 * 
 * reads file by line and each tab in the line is seperated into parts
 * the lines are read by the first letter and the parts are determined by what the line starts with
 * if line starts with q, choiceQuestion is added to an arraylist of the question list
 * if line starts with ?, answer is added to the arraylist of the question list answers
 * else, choiceLetter and choiceText are added to the arraylist of the question list choices
 * @author paula
 */

public class QuestionReader {
    
	public static ArrayList<Question> readQuestionsFromTextFile(String fname) {
		try {
			File f = new File(fname);
			return readQuestionsFromTextFile(f);
		} catch (Exception ex) {
			return null;
		}
	}

	public static ArrayList<Question> readQuestionsFromTextFile(File f) {
        ArrayList<Question> qList = new ArrayList<Question>();
        String line, choiceQuestion,choiceLetter,choiceText,answer;
        String[] parts;
        Question question = null;
        try {
			Scanner fsc = new Scanner(f);
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();                       //reads file by lines
                parts = line.split("\t");                           //splits file into parts
                if (line.startsWith("q")){
                    choiceQuestion = parts[1];                      //question is added here
                    question = new Question(choiceQuestion);
                    qList.add(question);
                } else if (line.startsWith("?")){
                    answer = parts[1];                              //answer is added here
                    question.addAnswer(answer);
                } else {
                    choiceLetter = parts[0];                        //choices are added here
                    choiceText = parts[1];
                    question.addChoice(choiceLetter,choiceText);
                }
            }
            fsc.close();
            return qList;
        } catch (Exception ex) {
            return null;
        }
    }
}
    

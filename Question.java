import java.util.LinkedHashMap;

/**
 * the model class that stores the text, choices, and answer for each question
 * choiceQuestion - question quizzer is asking
 * choiceLetter -   letter of choice answer option
 * choiceText - question answer choice 
 * answer - correct answer to question
 * LinkedHashMap created of choiceLetter and choiceText, to contain all of the (4) choices per each question
 * (i don't have any comments to add here, i mainly use the add getters/setters/constructors tool)
 * @author paula
 */

public class Question {
    private String choiceQuestion,choiceLetter,choiceText,answer;
    LinkedHashMap<String,String> choices = new LinkedHashMap<String,String>();
    

    public String getChoiceQuestion() {
        return choiceQuestion;
    }

    public void setChoiceQuestion(String choiceQuestion) {
        this.choiceQuestion = choiceQuestion;
    }

    public String getChoiceLetter() {
        return choiceLetter;
    }

    public void setChoiceLetter(String choiceLetter) {
        this.choiceLetter = choiceLetter;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LinkedHashMap<String, String> getChoices() {
        return choices;
    }

    public void setChoices(LinkedHashMap<String, String> choices) {
        this.choices = choices;
    }

    public Question() {
        choiceQuestion = "";
    }
    
    public Question(String choiceQuestion) {
        setChoiceQuestion(choiceQuestion);
    }

    public void addChoice(String choiceLetter, String choiceText) {
        setChoiceLetter(choiceLetter);
        setChoiceText(choiceText);
        choices.put(choiceLetter,choiceText);
    }

    public void addAnswer(String answer) {
        setAnswer(answer);
    }

    public Object getChoice(String letter) {
        return choices.get(letter);
    }


}
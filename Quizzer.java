import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * the class that asks the user a specified-number of questions at random from the list, 
 * making sure not to repeat any question in a round, and letting the user know what they got correct and incorrect
 * 
 * rQList: 
 * rQuestion - creates array list of random questions and amount of questions is determined by user
 * used - creates array list of the random numbers choosen by amt entered by user and within the question list size
 * qNum - number at random within the question list size
 * if used contains qNum, then it will skip that number and add a new one - making all questions not repeated
 * rQuestion adds randmomized question to the list
 * 
 * quiz:
 * choice - letter answer choice entered by user
 * doAgain - if user enters c, the program will continue
 * correct - amount of correct answers user entered per that set of questions
 * totalCorrect - total amount of correct answers user entered per the total amount of questions of all sets
 * qAmt - question amount entered by user
 * qAmtTotal - total question amount entered by user of all question sets
 * percentage - percentage of correct answers per question amount 
 * @author paula
 */

public class Quizzer { 

    private static ArrayList<Question> rQList (ArrayList<Question> qList, double qAmt) {
        ArrayList<Question> rQuestion = new ArrayList<Question>();
        ArrayList<Integer> used = new ArrayList<Integer>();
        Random random = new Random();
        int qNum;                           
        for (int i = 0; i < qAmt; i++) {                    //loops through amount of questions user entered
            do {
                qNum = random.nextInt(qList.size());        //determines qNum as the random number within the question list size
            } while (used.contains(qNum));                  //does not add numbers that are already in the used list
                rQuestion.add(qList.get(qNum));             //adds question to the random question list
                used.add(qNum);                             //adds number to the used list
        } return rQuestion;
    } 

    public int quiz(ArrayList<Question> qList){
        Scanner sc = new Scanner(System.in);
        String choice, doAgain;
        int correct = 0;
        int totalCorrect = 0;
        double qAmt = 0;
        double qAmtTotal = 0;
        double percentage = 0;
        System.out.println("The questions have been read. Are you ready to show how smart you are?");
        do {
            System.out.print("\nHow many questions do you want? ");
            qAmt = sc.nextDouble();                                                     //determines question amount
            if (qAmt > 20){
                System.out.println("There's only 20.");
                qAmt = 20;                                                              //it gives an error if there are more than 20, since there are only 20 questions
            }                                                                           //this was the quickest way for me to fix that, although i could have done this differently 
            qAmtTotal = qAmtTotal + qAmt;                                               //total question amount is created by adding the total by question amount
            ArrayList<Question> randomQ = rQList(qList, qAmt);                          //question list and question amount is sent to the random question function
            correct = 0;                                                                //resets correct to 0 for new question set
            for (int i = 0; i < qAmt; i++) {                                            //present questions amount of time user asked for question
                QuestionPrinter.printQuestion(randomQ.get(i));
                System.out.print("Enter letter of your choice: ");
                choice = sc.next();                                                     //ask user for the answer choice letter
                if (choice.equals(randomQ.get(i).getAnswer())){                         //if choice matches the answer then it is correct
                    System.out.println("Congratulations! That is correct.");
                    correct++;                                                          //adds to correct answer amount
                    totalCorrect++;                                                     //adds to total correct
                } else {
                    System.out.printf("Sorry. The correct answer was (%s) %s\n", randomQ.get(i).getAnswer(), randomQ.get(i).getChoice(randomQ.get(i).getAnswer()));
                }
            }
            percentage = correct/qAmt*100;                                              //percentage determined by dividing correct by question amount and dividing by 100
            System.out.printf("\nYou answer %s out of %.0f correctly, for percent score of %.2f\n", correct, qAmt,percentage);
            System.out.print("\nEnter c to continue or q to quit: ");
            doAgain = sc.next();                                                        //user must enter c to continue or q to quit
        } while (doAgain.equalsIgnoreCase("c"));
        percentage = totalCorrect/qAmtTotal*100;
        System.out.printf("\nYou got %s correct out of %.0f.", totalCorrect, qAmtTotal);
        System.out.printf("\nThat is good for %.2f percent.\n", percentage);
        System.out.print("\nBefore you go, here are all the questions and answers.");
        QuestionPrinter.printQuestionsAndAnswers(qList);                                //sends question list so it will print all questions and the correct answers
        System.out.print("\nWe've also written all the questions to an xml file named questions.xml.\n");
        System.out.print("\nWe hope you feel as smart as we are. Good bye.");
        sc.close();
        return correct;
    } 
}

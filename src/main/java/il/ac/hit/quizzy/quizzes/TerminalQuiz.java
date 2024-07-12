package il.ac.hit.quizzy.quizzes;

import il.ac.hit.quizzy.Answer;
import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.IQuizQuestion;
import il.ac.hit.quizzy.exceptions.InvalidChoiceException;
import il.ac.hit.quizzy.exceptions.QuizException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A terminal based quiz.
 */
public class TerminalQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions;

    public TerminalQuiz() {
        this.questions = new ArrayList<>();
    }

    @Override
    public void start() throws QuizException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(name);
        int score = 0;
        int total = questions.size();

        // Loop through all questions
        for (IQuizQuestion question : questions) {
            showQuestionTitleAndText(question);
            showAnswers(question);

            // Get the user's choice
            int choiceInNumber = getChoiceFromUser(reader);

            // Check if the choice is valid
            if(choiceInNumber < 1 || choiceInNumber > question.getAnswers().size()) {
                throw new InvalidChoiceException("Invalid choice: " + choiceInNumber);
            }

            // Check if the choice is correct
            if (question.getAnswers().get(choiceInNumber - 1).isCorrect()) {
                score++;
            }
        }

        printFinalScore(score, total);
    }

    /**
     * Displays the title and text of the given question.
     *
     * @param question the question to display
     */
    private void showQuestionTitleAndText(IQuizQuestion question) {
        System.out.println(question.getTitle());
        System.out.println(question.getQuestionText());
    }

    /**
     * Displays the answers of the given question.
     *
     * @param question the question to display answers for
     */
    private void showAnswers(IQuizQuestion question) {
        List<Answer> answers = question.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            System.out.println((i + 1) + ". " + answers.get(i).getText());
        }
    }

    /**
     * Prompts the user for their choice and returns it as an integer.
     *
     * @param reader the BufferedReader to read user input from
     * @return the user's choice as an integer
     * @throws QuizException if an I/O error occurs
     */
    private int getChoiceFromUser(BufferedReader reader) throws QuizException {
        try {
            System.out.println("Your choice: ");
            String choice = reader.readLine();
            return Integer.parseInt(choice);
        } catch (IOException e) {
            throw new QuizException("Error getting your choice", e);
        }
    }

    /**
     * Prints the final score of the quiz.
     *
     * @param score the user's score
     * @param total the total number of questions
     */
    private void printFinalScore(int score, int total) {
        System.out.println("Your score: " + score + "/" + total);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addQuestion(IQuizQuestion question) {
        questions.add(question);
    }

    @Override
    public List<IQuizQuestion> getQuestions() {
        return questions;
    }

    @Override
    public IQuiz clone() {
        try {
            //return a prototype of the quiz with the questions
            TerminalQuiz clone = (TerminalQuiz) super.clone();
            clone.questions = new ArrayList<>(this.questions);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

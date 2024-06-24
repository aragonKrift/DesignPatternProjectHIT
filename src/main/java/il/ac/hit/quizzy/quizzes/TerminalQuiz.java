package il.ac.hit.quizzy.quizzes;

import il.ac.hit.quizzy.Answer;
import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.IQuizQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TerminalQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions = new ArrayList<>();

    @Override
    public void start() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(name);
            int score = 0;
            int total = questions.size();

            for (IQuizQuestion question : questions) {
                System.out.println(question.getTitle());
                System.out.println(question.getQuestionText());

                List<Answer> answers = question.getAnswers();
                for (int i = 0; i < answers.size(); i++) {
                    System.out.println((i + 1) + ". " + answers.get(i).getText());
                }

                System.out.println("Your choice: ");
                String choice = reader.readLine();
                int choiceInNumber = Integer.parseInt(choice);
                if (answers.get(choiceInNumber - 1).isCorrect()) {
                    score++;
                }
            }

            System.out.println("Your score: " + score + "/" + total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public IQuiz clone() {
        try {
            TerminalQuiz clone = (TerminalQuiz) super.clone();
            clone.questions = new ArrayList<>(this.questions);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

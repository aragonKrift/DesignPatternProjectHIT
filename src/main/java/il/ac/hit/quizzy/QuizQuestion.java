package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a quiz question.
 * Implements the IQuizQuestion interface to provide the title, text, and possible answers of a quiz question.
 */
public class QuizQuestion implements IQuizQuestion {

    private final String title;
    private final String question;
    private final List<Answer> answers;

    /**
     * Constructs a new QuizQuestion with the specified title, question text, and answers.
     *
     * @param title the title of the quiz question.
     * @param question the text of the quiz question.
     * @param answers the list of possible answers for the quiz question.
     */
    protected QuizQuestion(String title, String question, List<Answer> answers) {
        this.title = title;
        this.question = question;
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestionText() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public static class Builder implements IQuizQuestionBuilder {
        private String title;
        private String question;
        private final List<Answer> answers;

        /**
         * Constructs a new Builder instance.
         * Initializes an empty list of answers.
         */
        public Builder() {
            answers = new ArrayList<>();
        }

        @Override
        public void setTitle(String text) {
            this.title = text;
        }

        @Override
        public void setQuestion(String text) {
            this.question = text;
        }

        @Override
        public void addAnswer(String text, boolean correct) {
            this.answers.add(new Answer(text, correct));
        }

        @Override
        public IQuizQuestion create() {
            return new QuizQuestion(title, question, answers);
        }
    }
}

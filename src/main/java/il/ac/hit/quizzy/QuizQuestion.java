package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion implements IQuizQuestion {

    private final String title;
    private final String question;
    private final List<Answer> answers;

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

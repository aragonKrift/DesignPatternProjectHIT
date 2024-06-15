package il.ac.hit.quizzy;

import il.ac.hit.quizzy.quizzes.GUIQuiz;
import il.ac.hit.quizzy.quizzes.TerminalQuiz;

public class QuizFactory {
    public IQuiz createQuiz(QuizType type) {
        return switch (type) {
            case GUI -> new GUIQuiz();
            case TERMINAL -> new TerminalQuiz();
        };
    }
}

package il.ac.hit.quizzy;

import il.ac.hit.quizzy.quizzes.GUIQuiz;
import il.ac.hit.quizzy.quizzes.TerminalQuiz;

public class QuizFactory {
    private final IQuiz guiQuizPrototype;
    private final IQuiz terminalQuizPrototype;

    public QuizFactory() {
        guiQuizPrototype = new GUIQuiz();
        terminalQuizPrototype = new TerminalQuiz();
    }

    public IQuiz createQuiz(QuizType type) {
        return switch (type) {
            case GUI -> guiQuizPrototype.clone();
            case TERMINAL -> terminalQuizPrototype.clone();
        };
    }
}

package il.ac.hit.quizzy;

import il.ac.hit.quizzy.quizzes.GUIQuiz;
import il.ac.hit.quizzy.quizzes.TerminalQuiz;

/**
 * Factory class for creating quiz instances.
 * This class provides methods to create different types of quizzes based on the specified QuizType.
 */
public class QuizFactory {
    private final IQuiz guiQuizPrototype;
    private final IQuiz terminalQuizPrototype;

    /**
     * Constructs a new QuizFactory with prototypes for GUI and Terminal quizzes.
     * Initializes the factory with a GUIQuiz prototype and a TerminalQuiz prototype.
     */
    public QuizFactory() {
        guiQuizPrototype = new GUIQuiz();
        terminalQuizPrototype = new TerminalQuiz();
    }

    /**
     * Creates a quiz instance based on the specified QuizType.
     * Returns a clone of the prototype corresponding to the QuizType.
     *
     * @param type the type of quiz to create, specified as a QuizType enum.
     * @return an instance of IQuiz corresponding to the specified QuizType.
     */
    public IQuiz createQuiz(QuizType type) {
        return switch (type) {
            case GUI -> guiQuizPrototype.clone();
            case TERMINAL -> terminalQuizPrototype.clone();
        };
    }
}

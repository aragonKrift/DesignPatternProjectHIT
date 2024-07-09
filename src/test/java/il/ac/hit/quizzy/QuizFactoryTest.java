package il.ac.hit.quizzy;

import il.ac.hit.quizzy.quizzes.GUIQuiz;
import il.ac.hit.quizzy.quizzes.TerminalQuiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizFactoryTest {
    private QuizFactory quizFactory;

    @BeforeEach
    void setUp() {
        quizFactory = new QuizFactory();
    }

    @Test
    void testCreateGUIQuiz() {
        IQuiz guiQuiz = quizFactory.createQuiz(QuizType.GUI);
        assertNotNull(guiQuiz);
        assertInstanceOf(GUIQuiz.class, guiQuiz);
        assertNotSame(guiQuiz, quizFactory.createQuiz(QuizType.GUI)); // Ensure clones are returned
    }

    @Test
    void testCreateTerminalQuiz() {
        IQuiz terminalQuiz = quizFactory.createQuiz(QuizType.TERMINAL);
        assertNotNull(terminalQuiz);
        assertInstanceOf(TerminalQuiz.class, terminalQuiz);
        assertNotSame(terminalQuiz, quizFactory.createQuiz(QuizType.TERMINAL)); // Ensure clones are returned
    }
}
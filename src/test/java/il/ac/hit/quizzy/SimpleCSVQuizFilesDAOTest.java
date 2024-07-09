package il.ac.hit.quizzy;

import il.ac.hit.quizzy.exceptions.QuizException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCSVQuizFilesDAOTest {
    private static final String TEST_FILE_NAME = "test_quiz.data";
    private IQuizFilesDAO quizFilesDAO;
    private IQuiz quiz;

    @BeforeEach
    void setUp() {
        QuizFactory factory = new QuizFactory();
        quizFilesDAO = SimpleCSVQuizFilesDAO.getInstance();

        //Create a sample quiz for testing
        quiz = factory.createQuiz(QuizType.TERMINAL);
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        builder.setQuestion("What is 2 + 2?");
        builder.addAnswer("3", false);
        builder.addAnswer("4", true);
        builder.addAnswer("5", false);
        quiz.addQuestion(builder.create());
    }

    @Test
    void testSaveAndLoadQuiz() {
        // Test saving quiz to file
        try {
            quizFilesDAO.saveQuizToFile(quiz, TEST_FILE_NAME);

            // Test loading quiz from file
            IQuiz loadedQuiz = quizFilesDAO.loadQuizFromFile(TEST_FILE_NAME);

            // Assert that loaded quiz is not null
            assertNotNull(quiz);

            // Assert that loaded quiz is equal to the original quiz
            assertEquals(quiz.getQuestions().size(), loadedQuiz.getQuestions().size());
            for (int i = 0; i < quiz.getQuestions().size(); i++) {
                assertEquals(quiz.getQuestions().get(i).getQuestionText(), loadedQuiz.getQuestions().get(i).getQuestionText());
            }
        } catch (QuizException e) {
            fail("Exception thrown while saving or loading quiz: " + e.getMessage());
        } finally {
            // Clean up (delete the test file)
            File file = new File(TEST_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    void testLoadNonExistingFile() {
        // Test loading from a non-existent file should throw QuizException
        assertThrows(QuizException.class, () -> quizFilesDAO.loadQuizFromFile("noneexistent_file.data"));
    }
}
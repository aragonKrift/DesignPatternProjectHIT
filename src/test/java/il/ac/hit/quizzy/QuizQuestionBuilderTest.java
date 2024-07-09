package il.ac.hit.quizzy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizQuestionBuilderTest {

    @Test
    void testQuizQuestionBuilder() {
        QuizQuestion.Builder builder = new QuizQuestion.Builder();
        builder.setTitle("Math Quiz");
        builder.setQuestion("What is 2 + 2?");
        builder.addAnswer("3", false);
        builder.addAnswer("4", true);
        builder.addAnswer("5", false);

        IQuizQuestion quizQuestion = builder.create();

        assertEquals("Math Quiz", quizQuestion.getTitle());

        assertEquals("What is 2 + 2?", quizQuestion.getQuestionText());

        List<Answer> answers = quizQuestion.getAnswers();
        assertEquals(3, answers.size());

        assertEquals("3", answers.get(0).getText());
        assertFalse(answers.get(0).isCorrect());

        assertEquals("4", answers.get(1).getText());
        assertTrue(answers.get(1).isCorrect());

        assertEquals("5", answers.get(2).getText());
        assertFalse(answers.get(2).isCorrect());
    }
}
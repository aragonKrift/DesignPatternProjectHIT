package il.ac.hit.quizzy;

import java.io.Serializable;

/**
 * Interface for implementing answers in a quiz.
 * This interface provides methods to retrieve the text of an answer and check if the answer is correct.
 */
public interface IAnswer extends Serializable {

    /**
     * Gets the text of the answer.
     *
     * @return the text of the answer as a String.
     */
    String getText();

    /**
     * Checks if the answer is correct.
     *
     * @return true if the answer is correct, false otherwise.
     */
    boolean isCorrect();
}

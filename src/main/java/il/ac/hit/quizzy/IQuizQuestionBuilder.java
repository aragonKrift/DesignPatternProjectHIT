package il.ac.hit.quizzy;

import java.io.Serializable;

/**
 * Interface for building a quiz question.
 * This interface provides methods to set the title, text, and answers for a quiz question,
 * and to create an instance of IQuizQuestion.
 */
public interface IQuizQuestionBuilder extends Serializable {

    /**
     * Sets the title of the quiz question.
     *
     * @param text the title of the quiz question as a String.
     */
    void setTitle(String text);

    /**
     * Sets the text of the quiz question.
     *
     * @param text the text of the quiz question as a String.
     */
    void setQuestion(String text);

    /**
     * Adds an answer to the quiz question.
     *
     * @param text the text of the answer as a String.
     * @param correct a boolean indicating whether the answer is correct.
     */
    void addAnswer(String text, boolean correct);

    /**
     * Creates an instance of IQuizQuestion with the specified title, text, and answers.
     *
     * @return an instance of IQuizQuestion.
     */
    IQuizQuestion create();
}

package il.ac.hit.quizzy;

import java.io.Serializable;
import java.util.List;

/**
 * Interface representing a quiz question.
 * This interface provides methods to retrieve the title, text, and possible answers of a quiz question.
 */
public interface IQuizQuestion extends Serializable {

    /**
     * Gets the title of the quiz question.
     *
     * @return the title of the quiz question as a String.
     */
    String getTitle();

    /**
     * Gets the text of the quiz question.
     *
     * @return the text of the quiz question as a String.
     */
    String getQuestionText();

    /**
     * Gets the list of possible answers for the quiz question.
     *
     * @return a list of Answer objects representing the possible answers.
     */
    List<Answer> getAnswers();
}

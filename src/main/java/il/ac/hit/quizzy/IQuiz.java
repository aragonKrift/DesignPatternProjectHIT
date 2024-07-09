package il.ac.hit.quizzy;

import il.ac.hit.quizzy.exceptions.QuizException;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for implementing a quiz.
 * This interface provides methods to initialize the quiz, set and get its title,
 * add questions, and clone the quiz according to the prototype design pattern.
 */
public interface IQuiz extends Cloneable, Serializable {

    /**
     * Starts the quiz and prints the final score.
     */
    void start() throws QuizException;

    /**
     * Sets the quiz title.
     *
     * @param name the title of the quiz.
     */
    void setName(String name);

    /**
     * Gets the quiz title.
     *
     * @return the title of the quiz.
     */
    String getName();

    /**
     * Adds a question to the quiz.
     *
     * @param question the IQuizQuestion instance to be added.
     */
    void addQuestion(IQuizQuestion question);

    /**
     * Gets the quiz questions as a list. For testing purposes only.
     *
     * @return list of the quiz's questions
     */
    List<IQuizQuestion> getQuestions();

    /**
     * Clones the quiz according to the prototype design pattern.
     *
     * @return the cloned quiz instance.
     */
    IQuiz clone();
}

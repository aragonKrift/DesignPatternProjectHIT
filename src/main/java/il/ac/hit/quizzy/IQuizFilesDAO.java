package il.ac.hit.quizzy;

import java.io.Serializable;

/**
 * Interface for implementing a DAO object for saving quizzes to a .data file.
 * This interface provides methods to save a quiz to a file and load a quiz from a file.
 */
public interface IQuizFilesDAO {

    /**
     * Saves a quiz to a specified file.
     *
     * @param quiz the IQuiz instance (GUI or TERMINAL) to be saved.
     * @param fileName the name of the file to save the quiz to.
     * @throws QuizException in case of an unsuccessful save operation.
     */
    void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException;

    /**
     * Loads a quiz from a specified file.
     *
     * @param fileName the name of the file from which the quiz is to be loaded.
     * @return the loaded IQuiz instance.
     * @throws QuizException in case of an unsuccessful load operation.
     */
    IQuiz loadQuizFromFile(String fileName) throws QuizException;
}

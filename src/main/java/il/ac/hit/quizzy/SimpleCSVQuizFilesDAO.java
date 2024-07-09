package il.ac.hit.quizzy;

import il.ac.hit.quizzy.exceptions.QuizException;

import java.io.*;

/**
 * Implementation of the IQuizFilesDAO interface for saving and loading quizzes to/from .data files.
 * This singleton class provides methods to save a quiz to a file and load a quiz from a file.
 */
public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO {
    private static SimpleCSVQuizFilesDAO instance;

    /**
     * Private constructor to prevent instantiation.
     */
    private SimpleCSVQuizFilesDAO() {}

    /**
     * Returns the singleton instance of SimpleCSVQuizFilesDAO.
     * If the instance is null, it creates a new instance.
     *
     * @return the singleton instance of SimpleCSVQuizFilesDAO.
     */
    public static IQuizFilesDAO getInstance() {
        if(instance == null) {
            instance = new SimpleCSVQuizFilesDAO();
        }
        return instance;
    }

    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(quiz);
        } catch (IOException e) {
            throw new QuizException("Can't save quiz to file", e);
        }
    }

    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        try(FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin)) {
            return (IQuiz) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new QuizException("Can't load quiz from file", e);
        }
    }
}

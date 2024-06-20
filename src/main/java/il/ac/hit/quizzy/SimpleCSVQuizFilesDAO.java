package il.ac.hit.quizzy;

import java.io.*;

public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO {
    private static SimpleCSVQuizFilesDAO instance;

    private SimpleCSVQuizFilesDAO() {}

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
//            throw new QuizException("Can't save quiz to file", e);
            e.printStackTrace();
        }
    }

    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        try(FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin)) {
            return (IQuiz) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
//            throw new QuizException("Can't load quiz from file", e);
            e.printStackTrace();
        }
        return null;
    }
}

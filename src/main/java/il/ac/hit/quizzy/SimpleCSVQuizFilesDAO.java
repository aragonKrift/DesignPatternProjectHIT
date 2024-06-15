package il.ac.hit.quizzy;

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

    }

    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        return null;
    }
}

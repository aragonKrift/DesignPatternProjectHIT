package il.ac.hit.quizzy;

import java.io.Serializable;

public interface IQuizFilesDAO {
    void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException;
    IQuiz loadQuizFromFile(String fileName) throws QuizException;
}

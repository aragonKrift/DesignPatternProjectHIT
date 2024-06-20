package il.ac.hit.quizzy;

import java.io.Serializable;

public interface IQuiz extends Cloneable, Serializable {
    void start();
    void setName(String text);
    String getName();
    void addQuestion(IQuizQuestion question);
    IQuiz clone();
}

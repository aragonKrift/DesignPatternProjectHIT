package il.ac.hit.quizzy;

import java.io.Serializable;

public interface IQuizQuestionBuilder extends Serializable {
    void setTitle(String text);
    void setQuestion(String text);
    void addAnswer(String text, boolean correct);
    IQuizQuestion create();
}

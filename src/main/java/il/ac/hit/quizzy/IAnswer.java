package il.ac.hit.quizzy;

import java.io.Serializable;

public interface IAnswer extends Serializable {
    String getText();
    boolean isCorrect();
}

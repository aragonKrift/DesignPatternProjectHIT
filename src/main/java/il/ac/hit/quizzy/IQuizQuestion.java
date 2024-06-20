package il.ac.hit.quizzy;

import java.io.Serializable;
import java.util.List;

public interface IQuizQuestion extends Serializable {
    String getTitle();
    String getQuestionText();
    List<Answer> getAnswers();
}

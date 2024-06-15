package il.ac.hit.quizzy;

public interface IQuizQuestionBuilder {
    void setTitle(String text);
    void setQuestion(String text);
    void addAnswer(String text, boolean correct);
    IQuizQuestion create();
}

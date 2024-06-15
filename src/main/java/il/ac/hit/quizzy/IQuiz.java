package il.ac.hit.quizzy;

public interface IQuiz extends Cloneable {
    void start();
    void setName(String text);
    String getName();
    void addQuestion(IQuizQuestion question);
    IQuiz clone();
}

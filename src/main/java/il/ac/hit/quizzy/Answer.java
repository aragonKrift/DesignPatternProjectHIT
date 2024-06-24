package il.ac.hit.quizzy;

/**
 * Represents an answer in a question.
 * Implements the IAnswer interface to provide the text of the answer and its correctness.
 */
public class Answer implements IAnswer {
    private final String text;
    private final boolean correct;

    /**
     * Constructs an Answer instance with the specified text and correctness.
     *
     * @param text the text of the answer.
     * @param correct a boolean indicating whether the answer is correct.
     */
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }
}

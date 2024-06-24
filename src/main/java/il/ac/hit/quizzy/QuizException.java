package il.ac.hit.quizzy;

/**
 * Exception class for handling quiz-related errors.
 * This class extends the Exception class to provide custom error messages and causes for exceptions that occur in the quiz application.
 */
public class QuizException extends Exception {

    /**
     * Constructs a new QuizException with the specified detail message.
     *
     * @param message the detail message as a String.
     */
    public QuizException(String message) {
        super(message);
    }

    /**
     * Constructs a new QuizException with the specified detail message and cause.
     *
     * @param message the detail message as a String.
     * @param cause the cause of the exception as a Throwable.
     */
    public QuizException(String message, Throwable cause) {
        super(message, cause);
    }
}

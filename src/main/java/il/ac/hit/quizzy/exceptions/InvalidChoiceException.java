package il.ac.hit.quizzy.exceptions;

/**
 * Exception thrown when an invalid choice is made in the quiz application.
 * This exception is typically used to indicate that the user has selected
 * an option that is not within the valid range of choices.
 */
public class InvalidChoiceException extends RuntimeException {
    /**
     * Constructs a new InvalidChoiceException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidChoiceException(String message) {
        super(message);
    }
}

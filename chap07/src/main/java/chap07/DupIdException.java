package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class DupIdException extends RuntimeException {
    public DupIdException() {
    }

    public DupIdException(String message) {
        super(message);
    }
}

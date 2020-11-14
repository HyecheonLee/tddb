package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class WeakPasswordException extends RuntimeException{
    public WeakPasswordException() {
    }

    public WeakPasswordException(String message) {
        super(message);
    }
}

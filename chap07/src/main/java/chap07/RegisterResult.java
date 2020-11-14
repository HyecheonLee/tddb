package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class RegisterResult {
    private CardValidity validity;

    public CardValidity getValidity() {
        return validity;
    }

    public RegisterResult(CardValidity validity) {
        this.validity = validity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(CardValidity.THEFT);
    }
}

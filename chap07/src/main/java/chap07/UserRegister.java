package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class UserRegister {
    private WeakPasswordChecker weakPasswordChecker;

    public UserRegister(WeakPasswordChecker weakPasswordChecker) {
        this.weakPasswordChecker = weakPasswordChecker;
    }

    public void register(String userId, String pw, String email) {
        if (weakPasswordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
    }
}

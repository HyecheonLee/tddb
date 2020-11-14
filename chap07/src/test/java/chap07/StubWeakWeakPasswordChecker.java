package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class StubWeakWeakPasswordChecker implements WeakPasswordChecker {
    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}

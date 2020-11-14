package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class SpyEmailNotifier implements EmailNotifier {
    private boolean called;
    private String email;

    public boolean isCalled() {
        return called;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void sendRegisterEmail(String email) {
        this.email = email;
        this.called = true;
    }
}

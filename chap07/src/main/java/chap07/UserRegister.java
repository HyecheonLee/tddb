package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class UserRegister {
    private WeakPasswordChecker weakPasswordChecker;
    private UserRepository repository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker weakPasswordChecker) {
        this(weakPasswordChecker, null);
    }

    public UserRegister(WeakPasswordChecker weakPasswordChecker, UserRepository repository) {
        this(weakPasswordChecker, repository, null);
    }

    public UserRegister(WeakPasswordChecker weakPasswordChecker, UserRepository repository, EmailNotifier emailNotifier) {
        this.weakPasswordChecker = weakPasswordChecker;
        this.repository = repository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        if (weakPasswordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        final User user = repository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        repository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}

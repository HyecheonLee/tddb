package chap07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakWeakPasswordChecker stubPasswordChecker = new StubWeakWeakPasswordChecker();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubPasswordChecker);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubPasswordChecker.setWeak(true);
        Assertions.assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });

    }
}

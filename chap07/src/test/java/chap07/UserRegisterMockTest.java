package chap07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class UserRegisterMockTest {
    private UserRegister userRegister;
    private WeakPasswordChecker mockWeakPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private UserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockWeakPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        BDDMockito.given(mockWeakPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

        org.junit.jupiter.api.Assertions.assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });

    }

    @DisplayName("회원 가입시 암호 검사 수행함")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw", "email");

        BDDMockito.then(mockWeakPasswordChecker)
                .should()
                .checkPasswordWeak(BDDMockito.anyString());
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@email.com");
        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should()
                .sendRegisterEmail(captor.capture());

        final String realEmail = captor.getValue();
        Assertions.assertThat(realEmail).isEqualTo("email@email.com");
    }
}

package chap07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class UserRegisterMockOverCaseTest {
    private UserRegister userRegister;
    private UserRepository mockRepository = Mockito.mock(UserRepository.class);
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, mockRepository, mockEmailNotifier);
    }

    @Test
    void noDupId_RegisterSuccess() {
        userRegister.register("id", "pw", "email");

        final ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        BDDMockito.then(mockRepository).should().save(captor.capture());

        final User savedUser = captor.getValue();
        Assertions.assertThat("id").isEqualTo(savedUser.getId());
        Assertions.assertThat("email").isEqualTo(savedUser.getEmail());
    }
}

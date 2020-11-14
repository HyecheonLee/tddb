package chap07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class AutoDebitRegisterTest {
    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        final CardNumberValidator validator = new CardNumberValidator();
        final AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() {
        final AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        final RegisterResult result = this.register.register(req);
        Assertions.assertThat(result.getValidity()).isEqualTo(CardValidity.THEFT);
    }
}
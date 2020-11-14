package chap07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;


    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        final AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, repository);
    }

    @Test
    void validCard() {
        stubValidator.setInvalidNo("111122223333");
        final AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        final RegisterResult result = this.register.register(req);
        Assertions.assertThat(result.getValidity()).isEqualTo(CardValidity.THEFT);
    }
}
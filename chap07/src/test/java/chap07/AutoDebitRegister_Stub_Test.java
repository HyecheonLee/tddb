package chap07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private AutoDebitInfoRepository repository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        repository = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, repository);
    }

    @Test
    void alreadyRegistered_InfoUpdated() {
        repository.save(new AutoDebitInfo("user1", "111222333444", LocalDateTime.now()));

        final AutoDebitReq req = new AutoDebitReq("user1", "123456789012");
        final RegisterResult result = this.register.register(req);

        final AutoDebitInfo saved = repository.findOne("user1");
        Assertions.assertThat(saved.getCardNumber()).isEqualTo("111222333444");
    }

    @Test
    void notYetRegistered_newInfoRegistered() {
        final AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        final RegisterResult result = this.register.register(req);

        final AutoDebitInfo saved = repository.findOne("user1");
        Assertions.assertThat(saved.getCardNumber()).isEqualTo("1234123412341234");
    }

    @Test
    void validCard() {
        stubValidator.setInvalidNo("111122223333");

        final AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        final RegisterResult result = this.register.register(req);

        Assertions.assertThat(result.getValidity()).isEqualTo(CardValidity.THEFT);
    }
}
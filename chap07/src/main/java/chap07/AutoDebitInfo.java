package chap07;

import java.time.LocalDateTime;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class AutoDebitInfo {
    private String userId;
    private String cardNumber;

    public AutoDebitInfo(String userId, String cardNumber) {
        this.userId = userId;
        this.cardNumber = cardNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime now) {
        this(userId, cardNumber);
    }

    public void changeCardNumber(Object cardNumber) {

    }
}

package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class AutoDebitReq {
    private String userId;
    private String cardNumber;

    public AutoDebitReq(String userId, String cardNumber) {
        this.userId = userId;
        this.cardNumber = cardNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

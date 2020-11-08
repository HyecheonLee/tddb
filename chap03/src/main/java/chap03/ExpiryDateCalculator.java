package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author hyecheon
 */
public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths(payData));
        } else {
            return payData.getBillingDate().plusMonths(addedMonths(payData));
        }
    }

    private int addedMonths(PayData payData) {
        return ((payData.getPayAmount() / 100_000) * 12) + ((payData.getPayAmount() % 100_000) / 100_00);
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        final LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if (!isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private int lastDayOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1 == date2;
    }
}

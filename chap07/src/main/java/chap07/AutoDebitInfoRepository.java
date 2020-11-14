package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public interface AutoDebitInfoRepository {
    AutoDebitInfo findOne(Object userId);

    void save(AutoDebitInfo newInfo);
}

package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public interface AutoDebitInfoRepository {
    AutoDebitInfo findOne(String userId);

    void save(AutoDebitInfo info);
}

package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public interface UserRepository {
    void save(User user);

    User findById(String id);
}

package chap07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class MemoryUserRepository implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}

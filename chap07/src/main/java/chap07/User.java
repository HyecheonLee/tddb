package chap07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class User {
    private String id;
    private String pw;
    private String email;

    public User(String id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getEmail() {
        return email;
    }
}

package users;

public class User {
    private String ID;
    private String username;
    private String password;

    public User(String ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public void authenticate() {
    }
}

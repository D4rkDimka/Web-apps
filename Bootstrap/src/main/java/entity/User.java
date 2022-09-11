package entity;

public class User {
    private String userName;
    private String email;
    private String password;
    private String gitName;

    public User(String userName, String email, String password, String gitName) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gitName = gitName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGitName() {
        return gitName;
    }
}

package com.prudnik.core.servlets.users;

public class User {
    private String login;
    private String password;
    public enum sex{
        MALE,
        FEMALE
    }
    private sex sex;
    private String description;
    public enum role{
        ADMIN,
        USER
    }
    private role role;

    public User(String login, String password, User.sex sex, String description, User.role role) {
        this.login = login;
        this.password = password;
        this.sex = sex;
        this.description = description;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User.sex getSex() {
        return sex;
    }

    public String getDescription() {
        return description;
    }

    public User.role getRole() {
        return role;
    }
}

package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class DBRepository {
    private static DBRepository dbRepository;
    private List<User> userList;

    private DBRepository() {
        userList = new ArrayList<>();
        userList.add(new User("ADMIN", "ADMIN", "ADMIN", "ADMIN"));
    }

    public static DBRepository getInstance() {
        if (dbRepository != null) {
            return dbRepository;
        } else {
            synchronized (DBRepository.class) {
                if (dbRepository == null) {
                    dbRepository = new DBRepository();
                }
                return dbRepository;
            }
        }
    }

    public void addNewUser(User user) {
        if (existingTest(user) == false) {
            throw new RuntimeException();
        } else {
            userList.add(user);
        }
    }

    public boolean existingTest(User user) {
        boolean isExist = false;

        for (User findUser : userList) {
            if (findUser.getUserName().equals(user.getUserName()) && findUser.getEmail().equals(user.getEmail()) && findUser.getPassword().equals(user.getPassword()) && findUser.getGitName().equals(user.getGitName())) {
                isExist = true;
            }
        }
        return isExist;
    }
}

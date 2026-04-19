package service;

import model.User;
import java.util.ArrayList;

public class LoginService {

    ArrayList<User> users = new ArrayList<>();
    String fileName = "users.txt";

    public LoginService() {
        users.add(new User("admin", "admin123"));
        users.add(new User("Khushi", "123"));
    }

    public boolean authenticate(String user, String pass) {

        for (User u : users) {
            if (u.getUsername().equals(user)
                    && u.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }
}

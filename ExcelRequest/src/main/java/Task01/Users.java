package Task01;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users;

    public Users() {
        users = new ArrayList<>();
        createUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    private void createUsers() {
        for (int i = 0; i < 15000; i++) {
            users.add(new User());
        }
    }
}

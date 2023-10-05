package hw3;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    //    Добавьте класс UserRepository для управления пользователями.
//    В этот класс должен быть включен метод
//    addUser, который добавляет пользователя в систему, если он прошел аутентификацию.
//    Покройте тестами новую функциональность
    private List<User> users = new ArrayList<>();

    public boolean addUser(User user, String login, String password) {
        if(user.authenticate(login, password)) {
            users.add(user);
            return true;
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }
}

package hw3;

public class User {
//    Разработайте класс User с методом аутентификации по логину и паролю.
//    Метод должен возвращать true, если
//    введенные логин и пароль корректны, иначе false. Протестируйте все методы
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean authenticate(String inputLogin, String inputPassword) {
        return login.equals(inputLogin) && password.equals(inputPassword);
    }




}

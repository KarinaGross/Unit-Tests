package hw3;

public class CheckNumber {
//    Напишите тесты, покрывающие на 100% метод evenOddNumber,
//    который проверяет, является ли переданное число четным или нечетным. (код приложен в презентации)
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

//    Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли переданное число
//    в интервал (25;100). (код приложен в презентации)
    public boolean numberInInterval(int n) {
        if (n < 100 && n > 25) {
            return true;
        } else {
            return false;
        }
    }

}

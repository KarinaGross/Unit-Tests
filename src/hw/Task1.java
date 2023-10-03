package hw;

import hw.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task1 {
    public static void main(String[] args) {
        testCalculateDiscountWithValidArguments();
        testCalculateDiscountWithNegativePurchaseAmount();
        testCalculateDiscountWithNegativeDiscount();
        testCalculateDiscountWithExcessiveDiscount();

        System.out.println(Calculator.calculateDiscount(1000, 10));
    }

//    Задание 1. ** В классе Calculator создайте метод calculateDiscount,
//    который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
//    Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
//    Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать
//    исключение ArithmeticException. Не забудьте написать тесты для проверки этого поведения.

    public static void testCalculateDiscountWithValidArguments() {
        double result = Calculator.calculateDiscount(1000, 10);
        assertThat(result).isEqualTo(900);
    }

    public static void testCalculateDiscountWithNegativePurchaseAmount() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(-1000, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid purchase amount or discount percentage");
    }

    public static void testCalculateDiscountWithNegativeDiscount() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid purchase amount or discount percentage");
    }

    public static void testCalculateDiscountWithExcessiveDiscount() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(1000, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid purchase amount or discount percentage");
    }
}

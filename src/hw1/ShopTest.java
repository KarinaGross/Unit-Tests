package hw1;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    private Shop shop;
    private Product product1;
    private Product product2;
    private Product product3;
    public void data() {
        shop = new Shop();
        product1 = new Product();
        product1.setCost(100);
        product1.setTitle("Product1");

        product2 = new Product();
        product2.setCost(50);
        product2.setTitle("Product2");

        product3 = new Product();
        product3.setCost(150);
        product3.setTitle("Product3");

        shop.setProducts(Arrays.asList(product1, product2, product3));
    }

//    *Задание 2. (необязательное) *
//    Мы хотим улучшить функциональность нашего интернет-магазина.
//    Ваша задача - добавить два новых метода в класс Shop:
//    Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
//    Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
//    Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
//    (правильное количество продуктов, верное содержимое корзины).
//    Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
//    Напишите тесты для проверки корректности работы метода sortProductsByPrice
//    (проверьте правильность сортировки). Используйте класс Product для создания
//    экземпляров продуктов и класс Shop для написания методов сортировки и тестов.

//     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
//     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
//     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов

    public void testProductsList() {
        List<Product> products = shop.getProducts();
        assertThat(products).containsExactly(product1, product2, product3);
        assertThat(products).hasSize(3);
    }

    public void testGetMostExpensiveProduct() {
        Product mostExpensive = shop.getMostExpensiveProduct();
        assertThat(mostExpensive).isEqualTo(product3);
    }

    public void testGetSortedListProducts() {
        List<Product> sortedProducts = shop.getSortedListProducts();
        assertThat(sortedProducts).containsExactly(product2, product1, product3);
    }

    public static void main(String[] args) {
        ShopTest test = new ShopTest();

        test.data();

        test.testProductsList();

        test.testGetMostExpensiveProduct();

        test.testGetSortedListProducts();
    }
}

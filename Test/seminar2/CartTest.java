package seminar2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CartTest {
    Shop shop;
    Cart cart;

    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        // Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }

        // тоже самое
        // Product product = new Product(1,"bacon", 170.00d, 10);
        // products.add(product);
        return products;
    }
    @BeforeEach
    void setUp() {
    shop = new Shop(getStoreItems());
    cart = new Cart(shop);
    }

    @Test
    void getTotalPriceDifferentProductsTest() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(4);

        assertThat(cart.getTotalPrice()).isEqualTo(770);
    }

    @Test
    void getTotalPriceSameProductsTest() {
        cart.addProductToCartByID(10);
        cart.addProductToCartByID(10);
        cart.addProductToCartByID(10);

        assertThat(cart.getTotalPrice()).isEqualTo(300);
    }

    @Test
    void getTotalPriceDifferentProductsWithDeletionTest() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(4);
        cart.removeProductByID(3);

        assertThat(cart.getTotalPrice()).isEqualTo(770 - 200);
    }

    @Test
    void getTotalQuantityShopTest() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);

        for (int i = 0; i < 3; i++) {
            assertThat(shop.getProductsShop().get(i).getQuantity()).isEqualTo(9);
        }
    }

    @Test
    void lastProductDisappearFromStore() {
        for (int i = 0; i < 11; i++) {
            cart.addProductToCartByID(1);
        }
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(0);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(10);
    }

    @Test
    void deletedProductIsReturnedToShop() {
        for (int i = 0; i < 3; i++) {
            cart.addProductToCartByID(1);
        }

        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(3);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(7);

        cart.removeProductByID(1);
        cart.removeProductByID(1);

        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(9);
    }



}
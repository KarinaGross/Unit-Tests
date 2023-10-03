package hw;

import hw.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        products.sort(Comparator.comparing(Product::getCost));
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        return products.stream().max(Comparator.comparing(Product::getCost)).orElse(null);
    }

//    public static void main(String[] args) {
//        Shop shop = new Shop();
//
//        Product product1 = new Product();
//        product1.setCost(100);
//        product1.setTitle("Product1");
//
//        Product product2 = new Product();
//        product2.setCost(50);
//        product2.setTitle("Product2");
//
//        Product product3 = new Product();
//        product3.setCost(150);
//        product3.setTitle("Product3");
//
//        shop.setProducts(Arrays.asList(product1, product2, product3));
//
//        System.out.println(shop.getMostExpensiveProduct());
//        System.out.println(shop.getSortedListProducts());
//    }
}

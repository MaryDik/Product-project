package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void аnExistingDeleteElement() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "хлеб", 50);
        Product product2 = new Product(2, "круассан", 80);
        Product product3 = new Product(3, "торт", 350);
        Product product4 = new Product(4, "кекс", 120);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.removeById(4);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void attemptToRemoveDefunctElement() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "хлеб", 50);
        Product product2 = new Product(2, "круассан", 80);
        Product product3 = new Product(3, "торт", 350);
        Product product4 = new Product(4, "кекс", 120);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(8);
        });

    }
}

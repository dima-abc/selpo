package ru.selpo.catalogue.repository;

import org.springframework.stereotype.Repository;
import ru.selpo.catalogue.entity.Product;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
@Repository
public class MemoryProductsRepository implements ProductRepository {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    public MemoryProductsRepository() {
        IntStream.rangeClosed(1, 4)
                .forEach(i -> this.products.add(new Product((long) i, "Товар №%d".formatted(i), "Описание товара №%d".formatted(i))));
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product save(Product product) {
        product.setId(
                this.products.stream()
                        .max(Comparator.comparingLong(Product::getId))
                        .map(Product::getId)
                        .orElse(0L) + 1);
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return this.products.stream()
                .filter(product -> Objects.equals(product.getId(), productId))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        this.products.removeIf(product -> Objects.equals(product.getId(), id));
    }
}

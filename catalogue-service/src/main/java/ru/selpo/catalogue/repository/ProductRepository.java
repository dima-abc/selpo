package ru.selpo.catalogue.repository;

import ru.selpo.catalogue.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long productId);

    void deleteById(Long id);
}

package ru.selpo.manager.repository;

import ru.selpo.manager.entity.Product;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);
}

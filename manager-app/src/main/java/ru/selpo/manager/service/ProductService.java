package ru.selpo.manager.service;

import ru.selpo.manager.entity.Product;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);
}

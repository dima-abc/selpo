package ru.selpo.manager.service;

import ru.selpo.manager.controller.payload.UpdateProductPayload;
import ru.selpo.manager.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(Integer productId);

    void updateProduct(Long id, UpdateProductPayload payload);

    void deleteProductById(Long id);
}

package ru.selpo.catalogue.service;


import ru.selpo.catalogue.controller.payload.UpdateProductPayload;
import ru.selpo.catalogue.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(int productId);

    void updateProduct(int productId, UpdateProductPayload payload);

    void deleteProductById(int id);
}

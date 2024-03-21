package ru.selpo.manager.client;

import ru.selpo.manager.controller.payload.UpdateProductPayload;
import ru.selpo.manager.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.03.2024
 */
public interface ProductsRestClient {
    List<Product> findAllProducts(String filter);

    Product createProduct(String title, String details);

    Optional<Product> findProduct(int productId);

    void updateProduct(int productId, UpdateProductPayload payload);

    void deleteProduct(int productId);
}

package ru.selpo.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.selpo.manager.controller.payload.UpdateProductPayload;
import ru.selpo.manager.entity.Product;
import ru.selpo.manager.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return productRepository.findById(Long.valueOf(productId));
    }

    @Override
    public void updateProduct(Long id, UpdateProductPayload payload) {
        this.productRepository.findById(id)
                .ifPresentOrElse(product -> {
                    product.setTitle(payload.title());
                    product.setDetails(payload.details());
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }
}

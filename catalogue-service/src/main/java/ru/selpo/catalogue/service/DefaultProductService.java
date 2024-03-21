package ru.selpo.catalogue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.selpo.catalogue.controller.payload.UpdateProductPayload;
import ru.selpo.catalogue.entity.Product;
import ru.selpo.catalogue.repository.ProductRepository;

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
    public Iterable<Product> findAllProducts(String filter) {
        if (filter != null && !filter.isBlank()) {
            return productRepository.findAllByTitleLikeIgnoreCase("%" + filter + "%");
        }
        return productRepository.findAll();
    }

    @Transactional
    @Override
    public Product createProduct(String title, String details) {
        return productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(int productId) {
        return productRepository.findById((long) productId);
    }

    @Transactional
    @Override
    public void updateProduct(int id, UpdateProductPayload payload) {
        this.productRepository.findById((long) id)
                .ifPresentOrElse(product -> {
                    product.setTitle(payload.title());
                    product.setDetails(payload.details());
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    @Override
    public void deleteProductById(int id) {
        this.productRepository.deleteById((long) id);
    }
}

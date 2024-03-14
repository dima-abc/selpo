package ru.selpo.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.selpo.manager.entity.Product;
import ru.selpo.manager.repository.ProductRepository;

import java.util.List;

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
}

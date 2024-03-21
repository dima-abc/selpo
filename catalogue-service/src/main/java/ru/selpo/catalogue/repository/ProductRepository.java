package ru.selpo.catalogue.repository;

import org.springframework.data.repository.CrudRepository;
import ru.selpo.catalogue.entity.Product;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAllByTitleLikeIgnoreCase(String filter);
}

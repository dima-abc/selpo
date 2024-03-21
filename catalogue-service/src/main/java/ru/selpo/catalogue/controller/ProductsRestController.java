package ru.selpo.catalogue.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.selpo.catalogue.controller.payload.NewProductPayload;
import ru.selpo.catalogue.entity.Product;
import ru.selpo.catalogue.service.ProductService;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.03.2024
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products")
public class ProductsRestController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> findProducts() {
        return this.productService.findAllProducts();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProduct(@Validated @RequestBody NewProductPayload payload,
                                           BindingResult bindingResult,
                                           UriComponentsBuilder uriComponentsBuilder) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            final Product product = this.productService.createProduct(payload.title(), payload.details());
            return ResponseEntity
                    .created(uriComponentsBuilder
                            .replacePath("/catalogue-api/products/{productId}")
                            .build(Map.of("productId", product.getId())))
                    .body(product);
        }
    }

}

package ru.selpo.catalogue.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.03.2024
 */
public record UpdateProductPayload(
        @NotNull(message = "{catalogue.products.update.errors.title_is_null}")
        @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_is_invalid}")
        String title,
        @Size(min = 3, max = 1000, message = "{catalogue.products.update.errors.details_size_are_invalid}")
        String details) {
}

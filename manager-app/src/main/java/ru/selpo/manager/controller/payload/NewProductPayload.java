package ru.selpo.manager.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
public record NewProductPayload(
        @NotNull(message = "{catalogue.products.create.errors.title_is_null}")
        @Size(min = 3, max = 50, message = "{catalogue.products.create.errors.title_size_is_invalid}")
        String title,
        @Size(min = 3, max = 1000, message = "{catalogue.products.create.errors.details_size_are_invalid}")
        String details) {
}

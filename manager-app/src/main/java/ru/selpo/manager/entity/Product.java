package ru.selpo.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String details;
}

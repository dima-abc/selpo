package ru.selpo.catalogue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.03.2024
 */
@SpringBootApplication
@Slf4j
public class CatalogueApp {
    public static void main(String[] args) {
        SpringApplication.run(CatalogueApp.class, args);
        log.info("CatalogueApp run GO TO http://localhost:{}", 8082);
    }
}

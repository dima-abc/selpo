package ru.selpo.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.03.2024
 */
@SpringBootApplication
@Slf4j
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class, args);
    }
}

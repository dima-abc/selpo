package ru.selpo.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.selpo.manager.client.ProductsRestClientImpl;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.03.2024
 */
@Configuration
public class ClientBeans {
    @Bean
    public ProductsRestClientImpl productsRestClient(@Value("${selpo.services.ctatalogue.url:http://localhost:8082}") String catalogueBaseUrl) {
        return new ProductsRestClientImpl(RestClient.builder()
                .baseUrl(catalogueBaseUrl)
                .build());
    }
}

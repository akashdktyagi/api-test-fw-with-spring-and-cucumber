package com.natyalabs.configs;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.natyalabs.openapi.codegen.client.api.PetApi;
import com.natyalabs.openapi.codegen.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class ApiClientConfig {

    @Value("${api.host}")
    String host;

    @Value("${api.username}")
    String username;

    @Value("${api.password}")
    String password;

    @Bean
    public ApiClient createForexSwapApiClient() {
        ApiClient client = new ApiClient();
        client.setBasePath(host);
        return client;
    }

    @Bean
    public PetApi createPetApi(ApiClient apiClient) {
        return new PetApi(apiClient);
    }

    @Bean
    public FakeValuesService createFakerService() {
         return new FakeValuesService(new Locale("en-GB"), new RandomService());
    }




}

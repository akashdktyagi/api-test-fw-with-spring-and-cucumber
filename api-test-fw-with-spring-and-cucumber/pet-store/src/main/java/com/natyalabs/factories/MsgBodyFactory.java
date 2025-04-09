package com.natyalabs.factories;

import com.github.javafaker.service.FakeValuesService;
import com.natyalabs.openapi.codegen.client.model.Category;
import com.natyalabs.openapi.codegen.client.model.Pet;
import com.natyalabs.openapi.codegen.client.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import java.util.List;

@Configuration
public class MsgBodyFactory {

    @Autowired
    FakeValuesService faker;

    @Bean
    @Scope("prototype")
    public Pet getPetBody(){
        return Pet.builder()
                .withTags(List.of(Tag.builder()
                        .withName("dog")
                        .build()))
                .withCategory(Category.builder()
                        .withName("dog")
                        .build())
                .withName(faker.letterify("??????????",false))
                .withStatus(Pet.StatusEnum.AVAILABLE)
                .withId(Long.valueOf(faker.numerify("#########")))
                .build();
    }
}

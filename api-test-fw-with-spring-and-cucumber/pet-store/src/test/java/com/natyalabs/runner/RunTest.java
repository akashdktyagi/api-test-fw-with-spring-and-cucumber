package com.natyalabs.runner;

import com.natyalabs.Main;
import com.natyalabs.openapi.codegen.client.api.PetApi;
import com.natyalabs.openapi.codegen.client.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
@ActiveProfiles("dev1")
@Slf4j
public class RunTest {

    @Autowired PetApi apiClient;
    @Autowired Pet pet;

    @Test
    public void testCreatePet(){
        log.info("Create pet body" + pet.toString());
        ResponseEntity<Void> entity = apiClient.addPetWithHttpInfo(pet);
        log.info("Response: " + entity.toString() + " Status code: " + entity.getStatusCode());
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    public void testCreatePet1(){
        pet.setName("wow");
        log.info("Create pet body" + pet.toString());
        ResponseEntity<Void> entity = apiClient.addPetWithHttpInfo(pet);
        log.info("Response: " + entity.toString() + " Status code: " + entity.getStatusCode());
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    public void testFindPets(){
        ResponseEntity<List<Pet>> entity = apiClient.findPetsByStatusWithHttpInfo(List.of("sold"));
        log.info("entity");
        log.info("Response: " + entity.toString() + " Status code: " + entity.getStatusCode());
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}

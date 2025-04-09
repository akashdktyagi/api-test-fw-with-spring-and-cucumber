package com.natyalabs.glue;

import com.natyalabs.openapi.codegen.client.api.PetApi;
import com.natyalabs.openapi.codegen.client.model.Pet;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class StepDefs {

    Scenario scenario;

    @Before
    public void setUp(Scenario scenario){
        this.scenario=scenario;

    }

    @Autowired PetApi apiClient;
    @Autowired Pet pet;

    ResponseEntity<List<Pet>> responseEntityGetPet;

    ResponseEntity<Void> responseEntityCreatePet;

    @Given("I have pet details")
    public void i_have_pet_details() {
        // pet object is auto wired to modify things here. if not then leave blank
    }
    @When("I create pet")
    public void i_create_pet() {
        //call the api client here
        responseEntityCreatePet = apiClient.addPetWithHttpInfo(pet);
    }
    @Then("Pet is created")
    public void pet_is_created() {
        Assertions.assertThat(responseEntityCreatePet.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Given("pets are available")
    public void pets_are_available() {
        //some data set up if required else empty
    }
    @When("I get the pet with status as {string}")
    public void i_get_the_pet_with_status_as(String status) {
        responseEntityGetPet = apiClient.findPetsByStatusWithHttpInfo(List.of(status));
        scenario.log(responseEntityGetPet.getBody().toString());
    }
    @Then("I get the list of pets with the status as {string}")
    public void i_get_the_list_of_pets_with_the_status_as(String string) {
        Assertions.assertThat(responseEntityGetPet.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));

    }

}

package com.natyalabs.glue;

import com.natyalabs.openapi.codegen.client.api.PetApi;
import com.natyalabs.openapi.codegen.client.model.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class StepDefs {

    @Autowired PetApi apiClient;
    @Autowired Pet pet;

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

    @Given("get pets are available")
    public void get_pets_are_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I get the pet with status as {string}")
    public void i_get_the_pet_with_status_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I get the list of pets with the status as {string}")
    public void i_get_the_list_of_pets_with_the_status_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

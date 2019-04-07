package api.pet;

import java.io.IOException;

import api.utils.PetsUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.apiwrappers.PetsApiWrapper;
import api.domain.pets.Pet;

public class BaseTestPet {

    private static final PetsApiWrapper petApiWrapper = new PetsApiWrapper();
    private static Pet petPayload;

    @BeforeClass
    private void generatePetPayload(){
        petPayload = PetsUtils.generateADefaultPetPayload();
    }

    @Test
    private void VerifyThatAPetIsSuccessfullyCreated() throws IOException {
        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        //The pet was successfully added
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        //Verify the pet via GET call
        Pet getResponsePet = petApiWrapper.getPetById(postResponsePet);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet, getResponsePet);
    }

    @Test
    private void VerifyThatAPetIsSuccessfullyDeleted() throws IOException {
        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        //The pet was successfully added
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        //Delete the order via DELETE call
        petApiWrapper.deletePetById(postResponsePet);
        Assert.assertEquals(petApiWrapper.getDeletePetResponse(), HttpStatus.SC_OK, "The pet " + postResponsePet.getId()
                + ", was not successfully deleted.");
    }
}

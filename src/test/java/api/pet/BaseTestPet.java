package api.pet;

import java.io.IOException;

import api.utils.PetsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.apiwrappers.PetsApiWrapper;
import api.domain.pets.Pet;

public class BaseTestPet {

    private static final PetsApiWrapper petApiWrapper = new PetsApiWrapper();
//    private Pet petPayload = null;
//
//    @BeforeMethod
//    void beforeMethod(){
//        Generate the payload for a pet
//        Pet petPayload = PetsUtils.generateADefaultPetPayload();
//    }

    @Test
    private void VerifyThatAPetIsSuccessfullyAdded() throws IOException {
        //Generate the payload for a pet
        Pet petPayload = PetsUtils.generateADefaultPetPayload();

        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        //The pet was successfully added
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        //Verify the pet via GET call
        Pet getResponsePet = petApiWrapper.getPetById(postResponsePet);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet, getResponsePet);
    }

}

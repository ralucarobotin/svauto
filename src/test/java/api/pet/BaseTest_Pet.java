package api.pet;

import java.io.IOException;

import api.utils.PetsUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import api.apiwrappers.PetsApiWrapper;
import api.domain.pets.Pet;
import api.utils.StoreUtils;

public class BaseTest_Pet {

    private static final PetsApiWrapper petApiWrapper = new PetsApiWrapper();

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

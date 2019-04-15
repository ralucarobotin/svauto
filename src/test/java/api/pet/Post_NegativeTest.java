package api.pet;

import api.apiwrappers.PetApiWrapper;
import api.domain.pets.Pet;
import api.utils.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_NegativeTest {
    private static final PetApiWrapper petApiWrapper = new PetApiWrapper();
    private static Pet petPayload;

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidId (){
        petPayload = PetsUtils.generatePetPayloadInvalidId();

        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_BAD_REQUEST, "The pet " + postResponsePet.getId()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyStatus(){
        petPayload = PetsUtils.generatePetPayloadEmptyStatus();
        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_BAD_REQUEST, "The pet's status " + postResponsePet.getStatus()
                + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidStatus(){
        petPayload = PetsUtils.generatePetPayloadInvalidStatus();
        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_BAD_REQUEST, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }
}

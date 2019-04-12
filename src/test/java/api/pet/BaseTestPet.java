package api.pet;

import api.utils.PetsUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.apiwrappers.PetApiWrapper;
import api.domain.pets.Pet;

public class BaseTestPet {

    private static final PetApiWrapper petApiWrapper = new PetApiWrapper();
    private static Pet petPayload;

    @BeforeClass
    private void generatePetPayload(){
        petPayload = PetsUtils.generateADefaultPetPayload();
    }

    @Test
    private void VerifyThatAPetIsSuccessfullyCreated(){
        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        //The pet was successfully added
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        //Verify the pet via GET call
        Pet getResponsePet = petApiWrapper.getPetById(postResponsePet);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet, getResponsePet);

        Assert.assertEquals(postResponsePet.getId(), getResponsePet.getId(),"The pets's id is wrong");
        Assert.assertEquals(postResponsePet.getCategory().getId(), getResponsePet.getCategory().getId(), "The pets's category id is wrong");
        Assert.assertEquals(postResponsePet.getCategory().getName(), getResponsePet.getCategory().getName(), "The pets's category name is wrong");
        Assert.assertEquals(postResponsePet.getName(), getResponsePet.getName(), "The pet's name is wrong");
        Assert.assertEquals(postResponsePet.getTags().get(0).getId(), getResponsePet.getTags().get(0).getId(),"The pets's tag id is wrong");
        Assert.assertEquals(postResponsePet.getTags().get(0).getName(), getResponsePet.getTags().get(0).getName(),"The pets's tag name is wrong");
        Assert.assertEquals(postResponsePet.getStatus(), getResponsePet.getStatus(),"The pet's status is wrong");
    }

    @Test
    private void VerifyThatAPetIsSuccessfullyDeleted(){
        //Process the pet
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        //The pet was successfully added
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        //Delete the order via DELETE call
        petApiWrapper.deletePetById(postResponsePet);
        Assert.assertEquals(petApiWrapper.getDeletePetResponseStatus(), HttpStatus.SC_OK, "The pet " + postResponsePet.getId()
                + ", was not successfully deleted.");
    }
}

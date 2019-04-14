package api.pet;

import api.domain.pets.Category;
import api.domain.pets.PetStatus;
import api.domain.pets.Tags;
import api.utils.PetsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.apiwrappers.PetApiWrapper;
import api.domain.pets.Pet;

import java.util.ArrayList;

public class Post_PositiveTest {
    private static final PetApiWrapper petApiWrapper = new PetApiWrapper();
    private static Pet petPayload, petPayload1,petPayload2, petPayload3;

//    @BeforeClass
//    private void generatePetPayload(){
//        petPayload = PetsUtils.generateADefaultPetPayload();
//    }

    @Test
    private void VerifyThatAPetIsSuccessfullyCreatedWithRandomData (){
        petPayload = PetsUtils.generateADefaultPetPayload();

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
    private void VerifyThatAPetIsSuccessfullyCreatedWithSpecificData (){
        petPayload = PetsUtils.generateASpecificPetPayload();

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
    private void VerifyThatMultiplePetsAreSuccessfullyCreatedWithRandomData (){
        petPayload1 = PetsUtils.generateADefaultPetPayload();
        petPayload2 = PetsUtils.generateADefaultPetPayload();
        petPayload3 = PetsUtils.generateADefaultPetPayload();

        //Process the pets
        Pet postResponsePet1 = petApiWrapper.postPet(petPayload1);
        Pet postResponsePet2 = petApiWrapper.postPet(petPayload2);
        Pet postResponsePet3 = petApiWrapper.postPet(petPayload3);

        //The pets were successfully added
        assert PetsUtils.checkIfPetsAreEqual(petPayload1, postResponsePet1);
        assert PetsUtils.checkIfPetsAreEqual(petPayload2, postResponsePet2);
        assert PetsUtils.checkIfPetsAreEqual(petPayload3, postResponsePet3);

        //Verify the pets via GET call
        Pet getResponsePet1 = petApiWrapper.getPetById(postResponsePet1);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet1, getResponsePet1);
        Pet getResponsePet2 = petApiWrapper.getPetById(postResponsePet2);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet2, getResponsePet2);
        Pet getResponsePet3 = petApiWrapper.getPetById(postResponsePet3);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet3, getResponsePet3);

        Assert.assertEquals(postResponsePet1.getId(), getResponsePet1.getId(),"The pets's id is wrong");
        Assert.assertEquals(postResponsePet1.getCategory().getId(), getResponsePet1.getCategory().getId(), "The pets's category id is wrong");
        Assert.assertEquals(postResponsePet1.getCategory().getName(), getResponsePet1.getCategory().getName(), "The pets's category name is wrong");
        Assert.assertEquals(postResponsePet1.getName(), getResponsePet1.getName(), "The pet's name is wrong");
        Assert.assertEquals(postResponsePet1.getTags().get(0).getId(), getResponsePet1.getTags().get(0).getId(),"The pets's tag id is wrong");
        Assert.assertEquals(postResponsePet1.getTags().get(0).getName(), getResponsePet1.getTags().get(0).getName(),"The pets's tag name is wrong");
        Assert.assertEquals(postResponsePet1.getStatus(), getResponsePet1.getStatus(),"The pet's status is wrong");

        Assert.assertEquals(postResponsePet2.getId(), getResponsePet2.getId(),"The pets's id is wrong");
        Assert.assertEquals(postResponsePet2.getCategory().getId(), getResponsePet2.getCategory().getId(), "The pets's category id is wrong");
        Assert.assertEquals(postResponsePet2.getCategory().getName(), getResponsePet2.getCategory().getName(), "The pets's category name is wrong");
        Assert.assertEquals(postResponsePet2.getName(), getResponsePet2.getName(), "The pet's name is wrong");
        Assert.assertEquals(postResponsePet2.getTags().get(0).getId(), getResponsePet2.getTags().get(0).getId(),"The pets's tag id is wrong");
        Assert.assertEquals(postResponsePet2.getTags().get(0).getName(), getResponsePet2.getTags().get(0).getName(),"The pets's tag name is wrong");
        Assert.assertEquals(postResponsePet2.getStatus(), getResponsePet2.getStatus(),"The pet's status is wrong");

        Assert.assertEquals(postResponsePet3.getId(), getResponsePet3.getId(),"The pets's id is wrong");
        Assert.assertEquals(postResponsePet3.getCategory().getId(), getResponsePet3.getCategory().getId(), "The pets's category id is wrong");
        Assert.assertEquals(postResponsePet3.getCategory().getName(), getResponsePet3.getCategory().getName(), "The pets's category name is wrong");
        Assert.assertEquals(postResponsePet3.getName(), getResponsePet3.getName(), "The pet's name is wrong");
        Assert.assertEquals(postResponsePet3.getTags().get(0).getId(), getResponsePet3.getTags().get(0).getId(),"The pets's tag id is wrong");
        Assert.assertEquals(postResponsePet3.getTags().get(0).getName(), getResponsePet3.getTags().get(0).getName(),"The pets's tag name is wrong");
        Assert.assertEquals(postResponsePet3.getStatus(), getResponsePet3.getStatus(),"The pet's status is wrong");
    }
}

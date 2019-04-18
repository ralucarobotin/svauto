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
    private static Pet petPayload;
    private static Category category = new Category();
    private static Tags tag = new Tags();
    private static ArrayList<Tags> tags = new ArrayList<>();

    @BeforeClass
    private void generatePetPayload(){
        petPayload = PetsUtils.generateADefaultPetPayload();
    }

    @Test
    private void VerifyThatAPetIsSuccessfullyCreatedWithRandomData (){
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
        petPayload.setId(5);
        category.setId(8);
        category.setName("Dog");
        petPayload.setCategory(category);
        petPayload.setName("Toto");
        tag.setId(6);
        tag.setName("Happy Doggo");
        tags.add(tag);
        petPayload.setTags(tags);
        petPayload.setStatus(PetStatus.AVAILABLE);

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
}

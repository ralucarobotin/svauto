package api.utils;

import api.domain.pets.Pet;
import api.domain.pets.PetStatus;
import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;

import java.util.ArrayList;

public class PetsUtils {

    public static Pet generateADefaultPetPayload(){
        Pet pet = new Pet();
        ArrayList<Tags> tags = new ArrayList<>();
        pet.setId(RandomUtils.nextInt(1, 5));
        pet.setCategory(CategoryUtils.generateDefaultCategory());
        pet.setName(RandomStringUtils.randomAlphabetic(20));
        tags.add(TagUtils.generateDefaultTag());
        pet.setTags(tags);
        pet.setStatus(PetStatus.generatePetRandomStatus());

        return pet;
    }

    public static boolean checkIfPetsAreEqual(Pet requestPayload, Pet responsePayload) {
        Assert.assertEquals(requestPayload.getId(), responsePayload.getId(),"The pets's id is wrong");
        Assert.assertEquals(requestPayload.getCategory().getId(), responsePayload.getCategory().getId(), "The pets's category id is wrong");
        Assert.assertEquals(requestPayload.getCategory().getName(), responsePayload.getCategory().getName(), "The pets's category name is wrong");
        Assert.assertEquals(requestPayload.getName(), responsePayload.getName(), "The pet's name is wrong");
        Assert.assertEquals(requestPayload.getTags().get(0).getId(), responsePayload.getTags().get(0).getId(),"The pets's tag id is wrong");
        Assert.assertEquals(requestPayload.getTags().get(0).getName(), responsePayload.getTags().get(0).getName(),"The pets's tag name is wrong");
        Assert.assertEquals(requestPayload.getStatus(), responsePayload.getStatus(),"The pet's status is wrong");

        return true;
    }
}

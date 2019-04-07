package api.utils;

import api.domain.pets.Category;
import api.domain.pets.Pet;
import api.domain.pets.PetStatus;
import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;

public class PetsUtils {

    public static Pet generateADefaultPetPayload(){
        Pet pet = new Pet();
        Category category = new Category();
        Tags tags = new Tags();

        pet.setId(RandomUtils.nextInt(1, 5));
        category.setId(RandomUtils.nextInt(1, 5));
        category.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setCategory(category);
        pet.setName(RandomStringUtils.randomAlphabetic(20));
        tags.setId(RandomUtils.nextInt(1, 5));
        tags.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setTags(tags);
        pet.setStatus(PetStatus.available);

        return pet;
    }

    public static boolean checkIfPetsAreEqual(Pet requestPayload, Pet responsePayload) {
        Assert.assertEquals(requestPayload.getId(), responsePayload.getId(),"The pets's id is wrong");
        Assert.assertEquals(requestPayload.getCategory().getId(), responsePayload.getCategory().getId(), "The pets's category id is wrong");
        Assert.assertEquals(requestPayload.getCategory().getName(), responsePayload.getCategory().getName(), "The pets's category name is wrong");
        Assert.assertEquals(requestPayload.getName(), responsePayload.getName(), "The pet's name is wrong");
        Assert.assertEquals(requestPayload.getTags().getId(), responsePayload.getTags().getId(),"The pets's tag id is wrong");
        Assert.assertEquals(requestPayload.getTags().getName(), responsePayload.getTags().getName(),"The pets's tag name is wrong");
        Assert.assertEquals(requestPayload.getStatus(), responsePayload.getStatus(),"The pet's status is wrong");

        return true;
    }
}

package api.utils;

import java.util.Objects;

import api.domain.pets.Category;
import api.domain.pets.Pet;
import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class PetsUtils {

    public static Pet generateADefaultPetPayload(){
        Pet pet = new Pet();
        Category category = new Category();
        Tags tags = new Tags();

        pet.setId(RandomUtils.nextInt(1, 3));
        category.setId(RandomUtils.nextInt(1, 3));
        category.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setCategory(category);
        pet.setName(RandomStringUtils.randomAlphabetic(20));
        tags.setId(RandomUtils.nextInt(1, 3));
        tags.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }

    public static boolean checkIfPetsAreEqual(Pet requestPayload, Pet responsePayload) {
        assert Objects.equals(requestPayload.getId(), responsePayload.getId()) : "The pets's id is wrong";
        assert Objects.equals(requestPayload.getCategory().getId(), responsePayload.getCategory().getId()) : "The pets's category id is wrong";
        assert requestPayload.getCategory().getName().equals(responsePayload.getCategory().getName()) : "The pets's category name is wrong";
        assert requestPayload.getName().equals(responsePayload.getName()) : "The pet's name is wrong";
        assert Objects.equals(requestPayload.getTags().getId(), responsePayload.getTags().getId()) : "The pets's tag id is wrong";
        assert requestPayload.getTags().getName().equals(responsePayload.getTags().getName()) : "The pets's tag name is wrong";
        assert requestPayload.getStatus().equals(responsePayload.getStatus()) : "The pet's status is wrong";

        return true;
    }
}

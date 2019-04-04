package api.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import api.domain.pets.Category;
import api.domain.pets.Pet;
import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;

public class PetsUtils {

    public static Pet generateADefaultPetPayload(){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(CategoryUtils.generateDefaultCategory(new BigDecimal(new Random().nextInt(20)),
                RandomStringUtils.randomAlphabetic(20)));
        ArrayList<Tags> tags = new ArrayList<>();
        tags.add(TagUtils.generateDefaultTag(new BigDecimal(new Random().nextInt(20)),
                RandomStringUtils.randomAlphabetic(20)));
        Pet pet = new Pet();

        pet.setId(new BigDecimal(new Random().nextInt(20)));
        pet.setCategory(categories);
        pet.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }

    public static boolean checkIfPetsAreEqual(Pet requestPayload, Pet responsePayload) {
        assert requestPayload.getId().equals(responsePayload.getId()) : "The pets's id is wrong";
        assert requestPayload.getCategory().equals(responsePayload.getCategory()) : "The pets's category id&name are wrong";
        assert requestPayload.getName().equals(responsePayload.getName()) : "The pet's name is wrong";
        assert requestPayload.getTags().equals(responsePayload.getTags()) : "The pets's tag id&name are wrong";
        assert requestPayload.getStatus().equals(responsePayload.getStatus()) : "The pet's status is wrong";

        return true;
    }
}

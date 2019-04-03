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
        categories.add(CategoryUtils.generateDefaultCategory());
        ArrayList<Tags> tags = new ArrayList<>();
        tags.add(TagUtils.generateDefaultTag());
        Pet pet = new Pet();

        pet.setId(new BigDecimal(new Random().nextInt(20)));
        pet.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setCategory(categories);
        pet.setName(RandomStringUtils.randomAlphabetic(20));
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }

    public static boolean checkIfPetsAreEqual(Pet requestPayload, Pet responsePayload) {
        assert requestPayload.getId().equals(responsePayload.getId()) : "The pets's id is wrong";
//        assert requestPayload.getCategory().equals(responsePayload.ca) : "The pets's id&name are wrong";
////        assert requestPayload.category.getId().equals(responsePayload.category.getId()) : "The pets's category id is wrong";
////        assert requestPayload.category.getName().equals(responsePayload.category.getName()) : "The pet's category name is wrong";
//        assert requestPayload.getName().equals(responsePayload.getName()) : "The pet's name is wrong";
////        assert requestPayload.tag.getId().equals(responsePayload.setTags().getId()) : "The pets's tag id is wrong";
////        assert requestPayload.tag.getName().equals(responsePayload.tag.getName()) : "The pets's tag name is wrong";
        assert requestPayload.getStatus().equals(responsePayload.getStatus()) : "The pet's status is wrong";

        return true;
    }
}

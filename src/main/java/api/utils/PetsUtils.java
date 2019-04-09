package api.utils;

import api.domain.pets.Pet;
import api.domain.pets.Tags;
import java.util.ArrayList;
import java.util.List;
import static helpers.Utilities.*;

public class PetsUtils {

    public static Pet generatePetPayload() {

        List<Tags> tags = new ArrayList<>();
        tags.add(TagsUtils.generateDefaultTags(generateNumbers(), generateCharacters()));

        Pet pet = new Pet();
        pet.setId(generateNumbers());
        pet.setCategory(CategoryUtils.generateDefaultCategory(generateNumbers(), generateCharacters()));
        pet.setName(generateCharacters());
        pet.setTags(tags);
        pet.setStatus(generatePetRandomStatus());

        return pet;
    }

    public static boolean checkIfPetsAreEqual(Pet requestPayload, Pet responsePayload) {

        assert requestPayload.getId().equals(responsePayload.getId()) : "The pet's id is wrong";
        assert requestPayload.getCategory().getId().equals(responsePayload.getCategory().getId()) : "The pets's id from category is wrong";
        assert requestPayload.getCategory().getName().equals(responsePayload.getCategory().getName()) : "The pets's name from category is wrong";
        assert requestPayload.getName().equals(responsePayload.getName()) : "The pet's name is wrong";
        assert requestPayload.getTags().get(0).getId().equals(responsePayload.getTags().get(0).getId()) : "The pets's id from tags is wrong";
        assert requestPayload.getTags().get(0).getName().equals(responsePayload.getTags().get(0).getName()) : "The pets's name from tags is wrong";
        assert requestPayload.getStatus().equals(responsePayload.getStatus()) : "The pet's status is wrong";

        return true;
    }
}

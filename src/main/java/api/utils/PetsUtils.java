package api.utils;

import java.util.ArrayList;

import api.domain.pets.Category;
import api.domain.pets.Pet;

public class PetsUtils {

    public static Pet generateADefaultPetPayload(){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(CategoryUtils.generateDefaultCategory());
        Pet pet = new Pet();
        pet.setName("Dog");
        pet.setCategory(categories);

        return pet;
    }
}

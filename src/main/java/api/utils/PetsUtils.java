package api.utils;

import api.domain.pets.Category;
import api.domain.pets.Pet;

import java.util.ArrayList;

public class PetsUtils {

    public static Pet generateADefaultPetPaylod() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(CategoryUtils.generateDefaultCategory());
        Pet pet = new Pet();
        pet.setName("Dog");
        pet.setCategory(categories);

        return pet;
    }
}

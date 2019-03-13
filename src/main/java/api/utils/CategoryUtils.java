package api.utils;

import api.domain.pets.Category;

class CategoryUtils {

    static Category generateDefaultCategory(){

        Category category = new Category();
        category.setId("1");
        category.setName("Animals");


        return category;
    }
}

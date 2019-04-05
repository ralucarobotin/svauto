package api.utils;

import api.domain.pets.Category;

class CategoryUtils {

    static Category generateDefaultCategory(int id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return category;
    }
}

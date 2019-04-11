package api.utils;

import api.domain.pets.Category;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

class CategoryUtils {

    static Category generateDefaultCategory() {
        Category category = new Category();
        int id = RandomUtils.nextInt(1, 5);
        String name = RandomStringUtils.randomAlphabetic(20);

        category.setId(id);
        category.setName(name);

        return category;
    }
}

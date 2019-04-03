package api.utils;

import api.domain.pets.Category;
import org.apache.commons.lang3.RandomStringUtils;

class CategoryUtils {

    static Category generateDefaultCategory() {
        Category category = new Category();
        category.setId(RandomStringUtils.randomNumeric(10));
        category.setName(RandomStringUtils.randomAlphabetic(20));

        return category;
    }
}

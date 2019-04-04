package api.utils;

import api.domain.pets.Category;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;

class CategoryUtils {

    static Category generateDefaultCategory(BigDecimal id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return category;
    }
}

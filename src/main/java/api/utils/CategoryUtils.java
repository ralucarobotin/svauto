package api.utils;

import api.domain.pets.Category;
import java.math.BigDecimal;

public class CategoryUtils {

    protected static Category generateDefaultCategory(BigDecimal id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return category;
    }
}

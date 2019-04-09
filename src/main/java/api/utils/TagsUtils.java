package api.utils;

import api.domain.pets.Tags;
import java.math.BigDecimal;

public class TagsUtils {

    protected static Tags generateDefaultTags(BigDecimal id, String name) {
        Tags tags = new Tags();
        tags.setId(id);
        tags.setName(name);

        return tags;
    }
}

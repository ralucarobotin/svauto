package api.utils;

import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;

public class TagUtils {

    static Tags generateDefaultTag(int id, String name) {
        Tags tag = new Tags();
        tag.setId(id);
        tag.setName(name);

        return tag;
    }
}

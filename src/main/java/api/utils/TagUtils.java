package api.utils;

import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;

public class TagUtils {

    static Tags generateDefaultTag() {
        Tags tag = new Tags();
        tag.setId(RandomStringUtils.randomNumeric(10));
        tag.setName(RandomStringUtils.randomAlphabetic(20));

        return tag;
    }
}

package api.utils;

import api.domain.pets.Tags;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class TagUtils {

    static Tags generateDefaultTag() {
        Tags tag = new Tags();
        int id = RandomUtils.nextInt(1, 5);
        String name = RandomStringUtils.randomAlphabetic(20);

        tag.setId(id);
        tag.setName(name);

        return tag;
    }
}

package api.pet;

import api.apiwrappers.PetApiWrapper;
import api.domain.pets.Category;
import api.domain.pets.Pet;
import api.domain.pets.PetStatus;
import api.domain.pets.Tags;
import api.utils.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Post_NegativeTest {
    private static final PetApiWrapper petApiWrapper = new PetApiWrapper();
    private static Pet petPayload;
    private static Category category = new Category();
    private static Tags tag = new Tags();
    private static ArrayList<Tags> tags = new ArrayList<>();

    @BeforeClass
    private void generatePetPayload(){
        petPayload = PetsUtils.generateADefaultPetPayload();
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidId(){
        petPayload.setId(-0);
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's Id " + postResponsePet.getId()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyId(){
        petPayload.setId(null);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's Id " + postResponsePet.getId()
                + ", is null");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyCategory(){
        petPayload.setCategory(null);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's category " + postResponsePet.getCategory()
                + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithINullCategoryId(){
        Integer id = null;
        String name = RandomStringUtils.randomAlphabetic(20);

        category.setId(id);
        category.setName(name);
        petPayload.setCategory(category);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's category id "
                + postResponsePet.getCategory().getId() + ", is null");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyCategoryName(){
        Integer id = RandomUtils.nextInt(1, 5);
        String name = StringUtils.EMPTY;

        category.setId(id);
        category.setName(name);
        petPayload.setCategory(category);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's category name " +
                postResponsePet.getCategory().getName() + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyName(){
        petPayload.setName(StringUtils.EMPTY);
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's name " + postResponsePet.getName()
                + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidSpaceCharacterName(){
        petPayload.setName(StringUtils.SPACE);
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's name " + postResponsePet.getName()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidAlpaNumericCharactersName(){
        petPayload.setName("asdsda378468523aasd");
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's name " + postResponsePet.getName()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidEmojiCharactersName(){
        petPayload.setName("\uD83D\uDE00\uD83D\uDE03\uD83D\uDE04\uD83D\uDE04\uD83D\uDE01\uD83D\uDE06\uD83D\uDE05\uD83D\uDE02♀️");
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's name " + postResponsePet.getName()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyTag(){
        petPayload.setTags(null);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's tag " + postResponsePet.getTags()
                + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithINullTagId(){
        Integer id = null;
        String name = RandomStringUtils.randomAlphabetic(20);

        tag.setId(id);
        tag.setName(name);
        tags.add(tag);
        petPayload.setTags(tags);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's tag id "
                + postResponsePet.getTags().get(0).getId() + ", is null");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyTagName(){
        Integer id = RandomUtils.nextInt(1, 5);
        String name = StringUtils.EMPTY;

        tag.setId(id);
        tag.setName(name);
        tags.add(tag);
        petPayload.setTags(tags);

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's tag name " +
                postResponsePet.getTags().get(0).getName() + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidAlphabeticCharactersStatus(){
        petPayload.setStatus(PetStatus.valueOf("asdaasd"));
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidNumericCharactersStatus(){
        petPayload.setStatus(PetStatus.valueOf("16161651651561"));
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidAlphaNumericCharactersStatus(){
        petPayload.setStatus(PetStatus.valueOf("werqweq354q533343qweasd"));
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidCharactersStatus(){
        petPayload.setStatus(PetStatus.valueOf("&%^$&*($^&(*)@#&$(&@(#_)$#$_#@($@"));
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidEmojiCharactersStatus(){
        petPayload.setStatus(PetStatus.valueOf("\uD83D\uDE00\uD83D\uDE03\uD83D\uDE04\uD83D\uDE04\uD83D\uDE01\uD83D\uDE06\uD83D\uDE05\uD83D\uDE02♀️"));
        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_NOT_FOUND, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyStatus(){
        petPayload.setStatus(PetStatus.valueOf(StringUtils.EMPTY));

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_BAD_REQUEST, "The pet's status " + postResponsePet.getStatus()
                + ", is empty");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithInvalidSpaceCharacterStatus(){
        petPayload.setStatus(PetStatus.valueOf(StringUtils.SPACE));

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_BAD_REQUEST, "The pet's status " + postResponsePet.getStatus()
                + ", is invalid");
    }

    @Test
    private void VerifyErrorWhenCreatingAPetWithEmptyData(){
        petPayload.setId(null);
        petPayload.setCategory(null);
        petPayload.setName(StringUtils.EMPTY);
        petPayload.setTags(null);
        petPayload.setStatus(PetStatus.valueOf(StringUtils.EMPTY));

        Pet postResponsePet = petApiWrapper.postPet(petPayload);

        Assert.assertEquals(petApiWrapper.getPostPetResponseStatus(), HttpStatus.SC_OK, "The pet's data " + postResponsePet.getStatus()
                + ", is empty");
    }
}

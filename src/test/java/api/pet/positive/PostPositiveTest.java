package api.pet.positive;

import api.utils.PetsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.apiwrappers.PetApiWrapper;
import api.domain.pets.Pet;

public class PostPositiveTest {
    private static final PetApiWrapper petApiWrapper = new PetApiWrapper();
    private static Pet petPayload;

    @BeforeMethod
    private void generatePetPayload(){
        petPayload = PetsUtils.generateADefaultPetPayload();
    }

    @Test
    private void VerifyThatAPetIsSuccessfullyCreatedWithRandomData (){
        Pet postResponsePet = petApiWrapper.postPet(petPayload);
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        Pet getResponsePet = petApiWrapper.getPetById(postResponsePet);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet, getResponsePet);
    }
}

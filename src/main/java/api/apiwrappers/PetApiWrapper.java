package api.apiwrappers;

import java.io.IOException;
import api.CommonApiWrapper;
import api.domain.pets.Pet;

public class PetApiWrapper extends CommonApiWrapper {

    private String petUrl = "/v2/pet";
    private String postPetUrl = "/v2/pet/";

    public Pet postPet(Pet pet) throws IOException {
        String endpoint = baseUrl + petUrl;

        return (Pet) post(pet, endpoint);
    }

    public Pet getPet(Pet pet) throws  IOException {
        String endpoint = baseUrl + postPetUrl + pet.getId().toString();

        return (Pet) get(pet, endpoint);
    }

    public Pet putPet(Pet pet) throws  IOException {
        String endpoint = baseUrl + postPetUrl + pet.getId().toString();

        return (Pet) put(pet, endpoint);
    }

    public void deletePet(Pet pet) throws  IOException {
        String endpoint = baseUrl + postPetUrl + pet.getId().toString();

        delete(endpoint);
    }
}

package api.apiwrappers;

import java.io.IOException;
import api.CommonApiWrapper;
import api.domain.pets.*;

public class PetsApiWrapper extends CommonApiWrapper{
    public Pet postPet(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet";

        return (Pet)post(pet, endpoint);
    }

    public Pet postPetById(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet/" + pet.getId();

        return (Pet)post(pet, endpoint);
    }

    public Pet postPetUploadImage(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet/" + pet.getId() + "/uploadImage";

        return (Pet)post(pet, endpoint);
    }

    public Pet putPet(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet";

        return (Pet)put(pet, endpoint);
    }

    public Pet getPetById(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet/" + pet.getId();

        return (Pet)get(pet, endpoint);
    }

    public Pet getPetFindByStatus(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet/findByStatus";

        return (Pet)get(pet, endpoint);
    }

    public Pet deletePetById(Pet pet) throws IOException {
        String endpoint = baseUrl + "/v2/pet/" + pet.getId();

        return (Pet)delete(endpoint);
    }
}

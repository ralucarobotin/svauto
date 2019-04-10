package api.apiwrappers;

import java.io.IOException;
import api.CommonApiWrapper;
import api.domain.pets.*;

public class PetsApiWrapper extends CommonApiWrapper{
    private String petEndpoint = baseUrl + "/v2/pet";

    public Pet postPet(Pet pet) throws IOException {
        return (Pet)post(pet, petEndpoint);
    }

    public Pet postPetById(Pet pet) throws IOException {
        return (Pet)post(pet, petEndpoint + pet.getId());
    }

    public Pet postPetUploadImage(Pet pet) throws IOException {
        return (Pet)post(pet, petEndpoint + "/" + pet.getId() + "/uploadImage");
    }

    public Pet putPet(Pet pet) throws IOException {
        return (Pet)put(pet, petEndpoint);
    }

    public Pet getPetById(Pet pet) throws IOException {
        return (Pet)get(pet, petEndpoint + "/" + pet.getId());
    }

    public Pet getPetFindByStatus(Pet pet) throws IOException {
        return (Pet)get(pet, petEndpoint + "/" + pet.getId());
    }

    public void deletePetById(Pet pet) throws IOException {
        delete(petEndpoint + "/" + pet.getId());
    }

    public int getGetPetResponseStatus(){
        return statusCode;
    }

    public int getPostPetResponseStatus(){
        return statusCode;
    }

    public int getDeletePetResponseStatus(){
        return statusCode;
    }
}

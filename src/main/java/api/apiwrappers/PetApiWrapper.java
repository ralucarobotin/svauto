package api.apiwrappers;

import java.io.IOException;
import api.CommonApiWrapper;
import api.domain.pets.*;

public class PetApiWrapper extends CommonApiWrapper{
    private String petEndpoint = baseUrl + "/v2/pet";

    public Pet postPet(Pet pet){
        return (Pet)post(pet, petEndpoint);
    }

    public Pet postPetById(Pet pet){
        return (Pet)post(pet, petEndpoint + pet.getId());
    }

    public Pet postPetUploadImage(Pet pet){
        return (Pet)post(pet, petEndpoint + "/" + pet.getId() + "/uploadImage");
    }

    public Pet putPet(Pet pet){
        return (Pet)put(pet, petEndpoint);
    }

    public Pet getPetById(Pet pet){
        return (Pet)get(pet, petEndpoint + "/" + pet.getId());
    }

    public Pet getPetFindByStatus(Pet pet)   {
        return (Pet)get(pet, petEndpoint + "/" + pet.getId());
    }

    public void deletePetById(Pet pet){
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

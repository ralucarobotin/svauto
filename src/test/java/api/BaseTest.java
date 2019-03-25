package api;

import api.domain.pets.Pet;
import api.utils.PetsUtils;

public class BaseTest {

    public static void main(String args[]){

        //[Test id] Verify that the pet is successfully created
        //Generate the payload
        Pet pet = PetsUtils.generateADefaultPetPaylod();

        //Preparing java object to be serialized ot Json format
        String payloadRequest = new JsonHelper().parseJavaObjectsToJson(pet);
        System.out.println(payloadRequest);

        //Perform POST call
        //TO DO

        //Response call is received in a Json format and needs to be deserialized to java object
        System.out.println(new JsonHelper().parseJsonToJava(payloadRequest, new Pet()));

        //Once the response payload is deserialized it can be asserted

    }
}
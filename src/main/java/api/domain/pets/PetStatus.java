package api.domain.pets;

import java.util.Random;

public enum PetStatusEnum {
    AVAILABLE, PENDING, SOLD;

    public static PetStatusEnum generatePetRandomStatus() {
        Random randomStatus = new Random();
        return values()[randomStatus.nextInt(values().length)];
    }
}

package api.domain.pets;

import java.util.Random;

public enum PetStatus {
    AVAILABLE, PENDING, SOLD;

    public static PetStatus generatePetRandomStatus() {
        Random randomStatus = new Random();
        return values()[randomStatus.nextInt(values().length)];
    }
}

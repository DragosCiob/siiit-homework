package siit.homework04.oop1;

public class Logan extends Dacia {

    public Logan(float availableFuel, String chassisNumber) {
        super(availableFuel, chassisNumber);
        this.fuelTankSize = 50;
        this.fuelType = "Diesel";
        this.gearBox = 5;
        this.consumptionPer100Km = 8.2f;
    }



}




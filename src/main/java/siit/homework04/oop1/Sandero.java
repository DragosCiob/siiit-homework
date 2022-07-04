package siit.homework04.oop1;

public class Sandero extends Dacia {

    public Sandero(float availableFuel, String chassisNumber) {
        super(availableFuel, chassisNumber);
        this.fuelTankSize = 45;
        this.fuelType = "Gasoline";
        this.gearBox = 5;
        this.consumptionPer100Km = 5.2f;
    }
}
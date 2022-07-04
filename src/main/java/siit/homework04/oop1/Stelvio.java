package siit.homework04.oop1;

public class Stelvio extends AlfaRomeo {

    public Stelvio(float availableFuel, String chassisNumber) {
        super(availableFuel, chassisNumber);
        this.fuelTankSize = 75;
        this.fuelType = "Gasoline";
        this.gearBox = 5;
        this.consumptionPer100Km = 11.0f;
    }


}


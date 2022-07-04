package siit.homework04.oop1;
public class Giulia extends AlfaRomeo {

    public Giulia(float availableFuel, String chassisNumber) {
        super(availableFuel, chassisNumber);
        this.fuelTankSize = 60;
        this.fuelType = "Diesel";
        this.gearBox = 6;
        this.consumptionPer100Km = 9.8f;
    }


}


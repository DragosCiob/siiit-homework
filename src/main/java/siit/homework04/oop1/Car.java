package siit.homework04.oop1;

public abstract class Car implements Vehicle {

    protected double fuelTankSize;
    protected String fuelType;
    protected int gearBox;
    protected float consumptionPer100Km;
    protected double availableFuel;

    protected String chassisNumber;

    private double tripConsumption;
    private double tripDistance;

    protected int gear;


    public Car(float availableFuel, String chassisNumber) {
        this.availableFuel = setAvailableFuel(availableFuel);
        this.chassisNumber = chassisNumber;
        this.gear = 1;
        this.tripConsumption = 0;
        this.tripDistance = 0;
    }

    @Override
    public void start() {
        System.out.println("Engine Starts");
        System.out.println("Previous trip consumption: " + tripConsumption);
        tripConsumption = 0;
        tripDistance = 0;

    }


    @Override
    public void stop() {
        System.out.println("Engine stop, trip consumption is: " + specificTripConsumption() + " average consumption: " + getAverageFuelConsumption());
    }

    @Override
    public void drive(double distanceToDrive, int gearNo) {
        System.out.println("fuel thank status: " + setAvailableFuel(availableFuel) );

        if (gearNo > gearBox || gearNo < 1) {
            System.out.println("out of the gears range");
            return;
        }
        gear = gearNo;


        double neededFuel = distanceToDrive * getTripConsumption() / 100;
        availableFuel = availableFuel - neededFuel;
        if (availableFuel < 0) {
            System.out.println("not enough quantity of fuel for this distance");
            return;
        } else {
            tripConsumption = tripConsumption + neededFuel;
            tripDistance = tripDistance + distanceToDrive;
            System.out.println(" Distance driven  " + distanceToDrive + " in gear no. " + gearNo);
        }
    }

    //the following could be implemented for each car model in specific configurations of map consuming
    public double getTripConsumption() {
        double tripConsumption = 0;
        float[] consumptionMap = new float[gearBox];
        consumptionMap[gearBox - 1] = consumptionPer100Km; // consumption cruising mode
        consumptionMap[0] = consumptionPer100Km * 1.5f; // consumption in raport 1
        consumptionMap[1] = consumptionPer100Km * 1.4f; // consumption in raport 2
        consumptionMap[2] = consumptionPer100Km * 1.3f; // consumption in raport 3
        consumptionMap[3] = consumptionPer100Km * 1.2f; // consumption in raport 4
        consumptionMap[4] = consumptionPer100Km * 1.1f; // consumption in raport 5

        if (gear == 1) {
            tripConsumption = consumptionMap[gear - 1];
        } else if (gear == 2) {
            tripConsumption = consumptionMap[gear - 1];
        } else if (gear == 3) {
            tripConsumption = consumptionMap[gear - 1];
        } else if (gear == 4) {
            tripConsumption = consumptionMap[gear - 1];
        } else if (gear == 5) {
            tripConsumption = consumptionMap[gear - 1];
        } else if (gear == gearBox) {
            tripConsumption = consumptionPer100Km;
        }

        return tripConsumption;

    }

    //returns the consumed quantity in respect with the chosen gear
    public double specificTripConsumption() {
        double specConsumption = tripDistance * getTripConsumption() / 100;
        return specConsumption;
    }

    //average of consumed quantity in respect with toatal distance
    public double getAverageFuelConsumption() {
        return (specificTripConsumption() * 100) / tripDistance;
    }



    public double setAvailableFuel(double availableFuel) {

        if (availableFuel > fuelTankSize) {
            System.out.println("the fuel thak size has only " + fuelTankSize);
           this.availableFuel = fuelTankSize;
        } else {
            this.availableFuel = availableFuel;
        }
        return availableFuel;
    }


}
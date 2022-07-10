package siit.homework04.oop2;


public  class GalaxyS20 extends Samsung {


    private String imei;

    public GalaxyS20(String color, String material, int batteryStatus, String imei) {
        super(12, color, material, batteryStatus, "GalaxyS20");
        this.imei = imei;
    }

}
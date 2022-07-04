package siit.homework04.oop1;

public class Main {

    public static void main(String[] args) {


        Car giulia = new Giulia(30, "ABC123");
        Car stelvio = new Stelvio(75, "CBA321");
        Car logan = new Logan(60,  "CBA321");
        Car sandero = new Sandero (15,  "CBA321");
        System.out.println("Giulia car");
        giulia.start();
        giulia.drive(10,2);
        giulia.drive(10,3);
        giulia.drive(10,4);
        giulia.stop();
        System.out.println("Stelvio car");
        stelvio.start();
        stelvio.drive(30,2);
        stelvio.stop();
        stelvio.start();
        stelvio.drive(30,5);
        stelvio.stop();
        System.out.println("Logan car");
        logan.start();
        logan.drive(30,1);
        logan.stop();

        System.out.println("Sandero car");
        sandero.start();
        sandero.drive(7500,1);
        sandero.stop();



    }
}
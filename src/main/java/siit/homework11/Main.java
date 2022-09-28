package siit.homework11;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("/Users/CD01813380/Desktop/java8.csv");
        FileProcessor readPrint= new FileProcessor();

        try {

            readPrint.processFile(path,6, "Persons");

            System.out.println(readPrint.getPersonList());

        } catch (IOException e) {
            System.out.println("file is not accessible");

        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
}

package siit.homework11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


class FileProcessorTest {

    @BeforeAll
    static void readFile() throws IOException {
        FileProcessor fileProcessor = new FileProcessor();
        Path path = Path.of("/Users/CD01813380/Desktop/java8.csv");
        fileProcessor.processFile(path, 1, "out.csv");
    }
    File outputFile = new File(".\\out.csv");
    Scanner in;
    {
        try {
            in = new Scanner(outputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    public void check_OutFile_Result() {
        String textToCheck = in.nextLine();

        Assertions.assertEquals("Daniel Pop/Mara Szabo/", textToCheck);

    }
}

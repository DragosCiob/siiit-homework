package siit.homework11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Integer.parseInt;

public class FileProcessor {

   private static List<Person>personList;

    /**
     *this method is used to process the input file and to write by calling writeOutFileMethod out the file having the names of Person instance ordered
     */
    public List<Person> processFile(Path path,  int month ,String fileOutName ) throws IOException {

        if(month > 12){
            throw new IllegalArgumentException("Please insert a value in between 1 and 12");
        }else{

//            List<Person>personList= null;

            personList = Files.lines(path)
                    .skip(1)
                    .map(FileProcessor::getPerson).filter(person -> person.getMonthOfBirth() == month )
                            .sorted(Comparator.comparing(Person::getLastName))
                            .collect(Collectors.toList());

            setPersonList(personList);
            writeOutFile(fileOutName);
            return personList;
        }


    }

    private static void writeOutFile(String fileOutName) throws FileNotFoundException {
        File csvFile= new File(fileOutName);
        PrintWriter out= new PrintWriter(csvFile);

        personList.forEach(person -> {
            out.write(person.toString());
        });

        out.close();
    }


    private static Person getPerson(String line) {
        String [] fields= line.split(",");
        String[] dates = fields[2].split("/");
        int month;
        month=parseInt(dates[1]);
        return new Person(fields[0], fields[1], month);
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }


}
    package siit.homework09;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Set;
    import java.util.TreeSet;
    import java.util.stream.Collectors;



    public class Reader{

      private List<Athlete> athleteList = new ArrayList<>();
      private List<String> ShootingResultList = new ArrayList<>();

        /**
         * the file is read once the reader has been instantiated
         */
        public Reader() {
            reading();
        }

        public void reading() {
            BufferedReader bufferedReader=null;
            String filePath="/Users/CD01813380/Desktop/biathlon.csv";
            String line= null;

            try {
                bufferedReader= new BufferedReader(new FileReader(filePath));

                while ((line=bufferedReader.readLine()) != null){

                    String[] attributes = line.split(",");

                    Athlete athlete = generateAthlete(attributes);
                    
                    athleteList.add(athlete);

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            setShootingResultList();
        }

        /**
         * method used to generate Athlete objects with information from the file
         */
        public static Athlete generateAthlete(String[] info) {

            String athleteNumber = info[0];
            String athleteName = info[1];
            String countryCode= info[2];
            String timeResult = info[3];
            String FirstShootingRange= info[4];
            String SecondShooting= info[5];
            String ThirdShootingRange = info[6];


            return new Athlete(athleteNumber,athleteName,countryCode,timeResult,FirstShootingRange,SecondShooting,ThirdShootingRange);

        }

        /**
         * method used to generate a list af all Athlete objects
         */
        public List<Athlete> getAthleteList() {
            return athleteList;
        }


//        public List<String> getName() {
//            return getAthleteList().stream()
//                    .map(Athlete::getAthleteName).collect(Collectors.toList());
//        }

        /**
         * method used to generate a list with the time results expressed in minutes and seconds
         */
        public List<String> getTimeResult() {
            return getAthleteList().stream()
                    .map(Athlete::getTimeResult).collect(Collectors.toList());
        }
        /**
         * method used to generate a list with the shooting result
         */
        public  List<String> getShootResult() {
            return getAthleteList().stream()
                    .map(Athlete::getShootingRange).collect(Collectors.toList());

        }


        /**
         * method used to convert in seconds the penalties
         */
        public  List<Integer> convertPenalties() {

            List<Integer> penalties = new ArrayList<>();

                for (String shoot : ShootingResultList) {
                    int penalty = 0;
                    if(shoot.matches("[xoXO]{15}")){
                        penalty += calculateShootingPenalty(shoot);
                        penalties.add(penalty);
                    }
                }
            return penalties;

        }



        public static Integer calculateShootingPenalty(String score){
            int shootingPenalty = 0;
            char [] arrayScore = score.toCharArray();
            for (char c : arrayScore) {
                if(c == 'O'){
                    shootingPenalty += 10;
                }
            }
            return shootingPenalty;
        }


        /**
         * method used create the member that contains the "scripted" results of the shooting sessions
         * ShootingResults list is called from reading() method block, therefore when the reader is instantiated
         */
        public void setShootingResultList() {
            ShootingResultList = getShootResult();
        }

        /**
         * method used to calculate the final time results after the penalties were applied
         */
        public  List<Integer> calculateFinalTimeResult() {
            // ("\\d+:\\d+")
            List<String> timeResult = getTimeResult();
            List<Integer> calculatedTimeResult = new ArrayList<>();
            String[] temp = new String[2];
            int seconds = 0;

             for (String time : timeResult) {
                int minutesToSeconds = 0;
                if(time.matches("\\d+:\\d+")){
                    temp = time.split(":");
                    minutesToSeconds = Integer.parseInt(temp[0])*60;
                    int penaltiesToAdd= convertPenalties().get(timeResult.indexOf(time));
                    seconds = Integer.parseInt(temp[1])+minutesToSeconds+penaltiesToAdd;
                    calculatedTimeResult.add(seconds);
                }

        }
            return calculatedTimeResult;
        }


        /**
         * method used to add the final time results to further generate the set collection of standing
         */
        public void replaceConvertedTime(){

            List<Integer> calculatedTimeResult = calculateFinalTimeResult();

            for (Athlete athlete: athleteList) {

                athlete.setFinalTime(calculatedTimeResult.get(athleteList.indexOf(athlete)));

            }

        }

        /**
         * method that creates the Standing collection Set using the FinalTime comparator
         */
        public Set<Athlete> generateStanding(){

          Set<Athlete> standing = new TreeSet<>(new FinalTimeComparator());
          replaceConvertedTime();
            standing.addAll(athleteList);

          return standing;
        }



    }

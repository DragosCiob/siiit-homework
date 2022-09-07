package siit.homework09;

public class Athlete {


    private final String athleteNumber;
    private final String athleteName;
    private final String countryCode;
    private final String timeResult;
    private final String FirstShootingRange;
    private final String SecondShooting;
    private final String ThirdShootingRange;
    private  int finalTime;


    public Athlete(String athleteNumber, String athleteName, String countryCode, String timeResult, String firstShootingRange, String secondShooting, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.timeResult = timeResult;
        FirstShootingRange = firstShootingRange;
        SecondShooting = secondShooting;
        ThirdShootingRange = thirdShootingRange;
        finalTime=0;
    }

//    public String getAthleteNumber() {
//        return athleteNumber;
//    }
//
//    public String getAthleteName() {
//        return athleteName;
//    }

//    public String getCountryCode() {
//        return countryCode;
//    }

    public String getTimeResult() {
        return timeResult;
    }

    public String getShootingRange() {
        return FirstShootingRange+SecondShooting+ThirdShootingRange;
    }


    public void setFinalTime(int finalTime) {
        this.finalTime = finalTime;
    }

    public Integer getFinalTime() {
        return finalTime;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber='" + athleteNumber + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", timeResult='" + timeResult + '\'' +
                ", FirstShootingRange='" + FirstShootingRange + '\'' +
                ", SecondShooting='" + SecondShooting + '\'' +
                ", ThirdShootingRange='" + ThirdShootingRange + '\'' +
                ", finalTime=" + finalTime +
                '}';
    }
}

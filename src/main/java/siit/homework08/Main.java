package siit.homework08;


public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();

        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);

        festivalStatisticsThread.start();

        //at each second one attendee is created with a valid ticket
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(gate.generateTicketType(), gate);
            festivalAttendeeThread.start();
        }

    }
}
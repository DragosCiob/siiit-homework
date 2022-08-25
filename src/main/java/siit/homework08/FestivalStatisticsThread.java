package siit.homework08;


import java.util.Map;

public class FestivalStatisticsThread extends Thread {

    private FestivalGate gate;

    /**
     * this thread has access to the gate instance
     */
    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }


    /**
     * every five second the thread is waked up and print the statistics
     */
    @Override
    public void run() {
        while(true) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!gate.getTicketStatistic().isEmpty()) {
                printStatistics();
            }
        }
    }


    private void printStatistics(){
        System.out.println(gate.getNrOfPersons()+"total attendees");
        for (Map.Entry<TicketType, Integer> entry : gate.getTicketStatistic().entrySet()){
            System.out.println(entry.getValue() + " ticket type " + entry.getKey());
        }
    }
}
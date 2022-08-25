package siit.homework08;

public class FestivalAttendeeThread extends Thread{
    private TicketType ticketType;
    private FestivalGate gate;


    /**
     * this thread has access to the gate instance and a ticket type
     */
    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {

        if (ticketType.equals(TicketType.FULL)||
                ticketType.equals(TicketType.FULL_VIP)||
                ticketType.equals(TicketType.FREE_PASS)||
                ticketType.equals(TicketType.ONE_DAY)||
                ticketType.equals(TicketType.ONE_DAY_VIP))
            this.ticketType = ticketType;
        else {
            throw new IllegalArgumentException("no access");
        }
        this.gate = gate;
    }

    // sleep method used in main
    @Override
    public void run(){
            System.out.println(ticketType);
            gate.updateStatistics(ticketType);

    }

    @Override
    public String toString() {
        return "FestivalAttendee"+ "ticketType=" + ticketType + " " +"gate=" + gate;
    }


}
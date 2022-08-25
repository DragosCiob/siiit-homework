package siit.homework08;

import java.util.*;

public class FestivalGate {

    private Queue<TicketType> ticketTypeQueue = new LinkedList<>();

    private int nrOfPersons;

    private Map<TicketType, Integer> ticketStatistic = new HashMap<>();


    public FestivalGate() {
        setTicketStatistic();
    }

    /**
     * for each instance of a gate a HasMap is initialized , the aim is to collect further on the information as statistics
     */
    private void setTicketStatistic() {
        for(TicketType ticketType: TicketType.values()){
            ticketStatistic.put(ticketType, 0);
        }
    }

    /**
     * the Queue that collects the tickets type is updated as well as the statistic collection
     */
    public void updateStatistics(TicketType ticket){
        ticketTypeQueue.add(ticket);
        nrOfPersons +=1;
        int nrOfTickets = ticketStatistic.get(ticket);
        ticketStatistic.put(ticket, nrOfTickets + 1);
    }

    /**
     * method that generate a random ticket
     */
    public TicketType generateTicketType(){
        List<TicketType> ticketTypes = Arrays.asList(TicketType.FULL, TicketType.FREE_PASS, TicketType.FULL_VIP, TicketType.ONE_DAY, TicketType.ONE_DAY_VIP);
        Random random = new Random();
        return ticketTypes.get(random.nextInt(ticketTypes.size()));
    }


    public Map<TicketType, Integer> getTicketStatistic() {
        return ticketStatistic;
    }

    public int getNrOfPersons() {
        return nrOfPersons;
    }
}


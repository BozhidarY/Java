package lab8.Constructors;

import lab8.Exceptions.NoMoreTicketException;

public class VolleyBallMatch extends Event{
    private String firstTeam;
    private String secondTeam;

    public VolleyBallMatch(String firstTeam, String secondTeam, String place, String date, String startHour,
                           int numberOfTickets, double priceOfTickets) {
        super(place, date, startHour, numberOfTickets, priceOfTickets);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    @Override
    boolean sellTicket(int num) throws NoMoreTicketException {
        if(getNumberOfTickets() < num){
            throw new NoMoreTicketException();
        }
        else{
            return true;
        }
    }
}

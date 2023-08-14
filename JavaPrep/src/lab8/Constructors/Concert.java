package lab8.Constructors;

import lab8.Exceptions.NoMoreTicketException;

public class Concert extends Event{
    private String starName;

    public Concert(String starName, String place, String date, String startHour, int numberOfTickets, double priceOfTickets ) {
        super(place, date, startHour, numberOfTickets, priceOfTickets);
        this.starName = starName;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    @Override
     public boolean sellTicket(int num) throws NoMoreTicketException {
        if(getNumberOfTickets() < num){
            throw new NoMoreTicketException();
        }
        else{
            return true;
        }
    }
    @Override
    public String toString() {
        return "Concert{" +
                "starName='" + starName + '\'' +
                '}';
    }
}

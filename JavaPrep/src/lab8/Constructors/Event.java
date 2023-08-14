package lab8;

import lab8.Exceptions.NoMoreTicketException;

public abstract class Event {

    private String place;
    private String startHour;
    private int numberOfTickets;
    private double priceOfTickets;

    public Event(String place, String startHour, int numberOfTickets, double priceOfTickets) {
        this.place = place;
        this.startHour = startHour;
        this.numberOfTickets = numberOfTickets;
        this.priceOfTickets = priceOfTickets;
    }

    abstract boolean sellTicket(int num) throws NoMoreTicketException;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getPriceOfTickets() {
        return priceOfTickets;
    }

    public void setPriceOfTickets(double priceOfTickets) {
        this.priceOfTickets = priceOfTickets;
    }
}

package ca.sait.flightfindr.models;

/**
 * Represents a flight.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class Flight {
    private String code;
    private String departure;
    private String destination;
    private String day;
    private String time;
    private int seats;
    private double cost;
    
    /**
     * Initializes a Flight instance.
     * @param code Flight code
     * @param departure Departing city
     * @param destination Destination city
     * @param day Day of week when flight leaves
     * @param time Time flight leaves
     * @param seats # of seats on airplane.
     * @param cost Cost of single ticket.
     */
    public Flight(String code, String departure, String destination, String day, String time, int seats, double cost) {
        this.code = code;
        this.departure = departure;
        this.destination = destination;
        this.day = day;
        this.time = time;
        this.seats = seats;
        this.cost = cost;
    }
    
    /**
     * Gets flight code
     * @return Flight code
     */
    public String getCode() {
        return this.code;
    }
    
    /**
     * Gets departing city
     * @return Departing city
     */
    public String getDeparture() {
        return this.departure;
    }
    
    /**
     * Gets destination city
     * @return Destination city
     */
    public String getDestination() {
        return this.destination;
    }
    
    /**
     * Gets day of week when flight leaves
     * @return Day of week when flight leaves
     */
    public String getDay() {
        return this.day;
    }
    
    /**
     * Gets time when flight leaves
     * @return Time when flight leaves
     */
    public String getTime() {
        return this.time;
    }
    
    /**
     * Gets # of seats on flight
     * @return # of seats on flight
     */
    public int getSeats() {
        return this.seats;
    }
    
    /**
     * Gets cost of single ticket
     * @return Cost of single ticket
     */
    public double getCost() {
        return this.cost;
    }
}

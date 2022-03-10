package ca.sait.flightfindr.models;

import java.sql.Date;

/**
 * Represents a booking.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class Booking {
    private int id;
    private int accountId;
    private String flightCode;
    private Date createdAt;
    
    /**
     * Initializes a Booking instance.
     * @param id Booking ID
     * @param accountId Account ID
     * @param flightCode Flight code
     * @param createdAt Date booking was created
     */
    public Booking(int id, int accountId, String flightCode, Date createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.flightCode = flightCode;
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the booking ID
     * @return Booking ID
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Sets the booking ID
     * @param id Booking ID
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Gets the account ID
     * @return Account ID
     */
    public int getAccountId() {
        return this.accountId;
    }
    
    /**
     * Sets account ID
     * @param accountId Account ID
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Gets flight code
     * @return Flight code
     */
    public String getFlightCode() {
        return this.flightCode;
    }
    
    /**
     * Sets flight code
     * @param flightCode Flight code
     */
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
    
    /**
     * Gets when booking was created
     * @return Booking creation date/time.
     */
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    /**
     * Sets when booking was created
     * @param createdAt Booking creation date/time.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

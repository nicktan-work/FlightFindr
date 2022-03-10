package ca.sait.flightfindr.dataaccess;

import ca.sait.flightfindr.models.Account;
import ca.sait.flightfindr.models.Booking;
import ca.sait.flightfindr.models.Flight;
import java.sql.*;

/**
 * Performs database operations on bookings.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class BookingService {
    private DatabaseDriver driver;
    
    public BookingService() {
        this.driver = new DatabaseDriver();
    }
    
    /**
     * Creates a booking that is associated with an existing account and existing flight.
     * @param account Account instance
     * @param flight Flight instance
     * @return True if booking was created
     * @throws SQLException Thrown if an exception occurred communicating with the database.
     */
    public Booking createBooking(Account account, Flight flight) throws SQLException {
        Booking booking = new Booking(0, account.getId(), flight.getCode(), null);
        
        Statement stmt = this.driver.getConnection().createStatement();
        
        String sql = String.format("INSERT INTO bookings (account_id, flight_code) VALUES(%d, '%s')", booking.getAccountId(), flight.getCode());
        int affected = stmt.executeUpdate(sql);
        
        return (affected > 0 ? booking : null);
    }
}

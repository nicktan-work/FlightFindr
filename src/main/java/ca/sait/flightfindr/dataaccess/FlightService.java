package ca.sait.flightfindr.dataaccess;

import ca.sait.flightfindr.models.Flight;
import java.sql.*;
import java.util.ArrayList;

/**
 * Performs database operations on flights.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class FlightService {
    private DatabaseDriver driver;
    
    public FlightService() {
        this.driver = new DatabaseDriver();
    }
    
    /**
     * Finds flights matching departure and destination query.
     * @param departureQuery Departure search query (use % as wildcard)
     * @param destinationQuery Destination search query (use % as wildcard)
     * @return ArrayList containing found flights.
     * @throws SQLException Thrown if an exception occurred communicating with the database.
     */
    public ArrayList<Flight> findFlights(String departureQuery, String destinationQuery) throws SQLException {
        Statement stmt = this.driver.getConnection().createStatement();
        
        String sql = String.format("SELECT * FROM flights WHERE departure LIKE '%s' AND destination LIKE '%s'", departureQuery, destinationQuery);
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<Flight> found = new ArrayList<>();
        
        while (rs.next()) {
            String code = rs.getString("code");
            String departure = rs.getString("departure");
            String destination = rs.getString("destination");
            String day = rs.getString("day");
            String time = rs.getString("time");
            int seats = rs.getInt("seats");
            double cost = rs.getDouble("cost");

            Flight flight = new Flight(code, departure, destination, day, time, seats, cost);
            found.add(flight);
        }
        
        return found;
    }
    
    /**
     * Gets a flight by code.
     * @param code Flight code
     * @return Found flight, otherwise, null if not found.
     * @throws SQLException Thrown if an exception occurred communicating with the database.
     */
    public Flight getByCode(String code) throws SQLException {
        Statement stmt = this.driver.getConnection().createStatement();
        
        String sql = String.format("SELECT * FROM flights WHERE code = '%s'", code);
        ResultSet rs = stmt.executeQuery(sql);
        
        if (!rs.next())
            return null;
        
        String departure = rs.getString("departure");
        String destination = rs.getString("destination");
        String day = rs.getString("day");
        String time = rs.getString("time");
        int seats = rs.getInt("seats");
        double cost = rs.getDouble("cost");

        Flight flight = new Flight(code, departure, destination, day, time, seats, cost);
        return flight;
    }
}

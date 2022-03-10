package ca.sait.flightfindr.dataaccess;

import ca.sait.flightfindr.models.Account;
import java.sql.*;

/**
 * Performs database operations on accounts.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class AccountService {
    private DatabaseDriver driver;
    
    public AccountService() {
        this.driver = new DatabaseDriver();
    }
    
    /**
     * Finds an account with email address.
     * @param email Email address
     * @return Account instance, otherwise, null if not found.
     * @throws SQLException Thrown if an exception occurred communicating with the database.
     */
    public Account getByEmail(String email) throws SQLException {
        Statement stmt = this.driver.getConnection().createStatement();
        
        String sql = String.format("SELECT * FROM accounts WHERE email = '%s'", email);
        
        ResultSet rs = stmt.executeQuery(sql);
        
        if (!rs.next())
            return null;
        
        int id = rs.getInt("id");
        String password = rs.getString("password");
        String name = rs.getString("name");
        String creditCard = rs.getString("creditcard");
        
        Account account = new Account(id, email, password, name, creditCard);
        
        return account;
    }
    
    /**
     * Updates an existing account.
     * @param account Account instance
     * @return True if account was updated
     * @throws SQLException Thrown if an exception occurred communicating with the database.
     */
    public boolean update(Account account) throws SQLException {
        Statement stmt = this.driver.getConnection().createStatement();
        
        String sql = 
            String.format(
                "UPDATE accounts SET email = '%s', password = '%s', name = '%s', creditcard = '%s' WHERE id = %d", 
                account.getEmail(), account.getPassword(), account.getName(), account.getCreditCard(), account.getId()
            );
        
        int affected = stmt.executeUpdate(sql);
        
        return affected > 0;
    }
}

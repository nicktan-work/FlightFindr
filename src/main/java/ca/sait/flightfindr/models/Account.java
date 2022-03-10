package ca.sait.flightfindr.models;

/**
 * Represents an account.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class Account {
    private int id;
    private String email;
    private String password;
    private String name;
    private String creditCard;
    
    /**
     * Initializes a new Account instance.
     * @param id Account ID
     * @param email Email address
     * @param password Password
     * @param name Name
     * @param creditCard Credit card number 
     */
    public Account(int id, String email, String password, String name, String creditCard) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.creditCard = creditCard;
    }
    
    /**
     * Gets account ID
     * @return Account ID
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Sets account ID
     * @param id Account ID
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Gets email address
     * @return Email address
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * Sets email address
     * @param email Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets password
     * @return password
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Sets password
     * @param password Password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets name
     * @return Name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets name
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets credit card number
     * @return Credit card number
     */
    public String getCreditCard() {
        return this.creditCard;
    }
    
    /**
     * Sets credit card number
     * @param creditCard 
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}

import java.util.ArrayList; 
import java.util.Date;

/**
 * Class Booking, used to create a booking object for a property 
 * @author User
 */
public class Booking {
    private Date date;  
    private Agence agence; 
    private Buyer buyer; 
    private Property property; 

    /**
     *Constructor, creates a booking objet with his date, concerned property, date of the visit, interested buyer and the agence
     * @param date
     * @param agence
     * @param buyer
     * @param property
     */
    public Booking(Date date, Agence agence, Buyer buyer, Property property) {
        this.date = date;
        this.agence = agence;
        this.buyer = buyer;
        this.property = property;
    }
    
    /**Constructor with only date, buyer and property
     *
     * @param date
     * @param buyer
     * @param property
     */
    public Booking(Date date, Buyer buyer, Property property){
        this.date = date; 
        this.buyer = buyer; 
        this.property = property; 
    }

   // GETTERS 

    /**
     * returns the date
     * @return date
     */

    public Date getDate() {
        return date;
    }

    /**
     * returns the agence object
     * @return agence
     */
    public Agence getAgence() {
        return agence;
    }

    /**
     * returns the buyer object
     * @return buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * returns the property object
     * @return property
     */
    public Property getProperty() {
        return property;
    }
    
    
    // SETTERS 

    /**
     * sets the date parameter of a booking
     * @param date
     */

    public void setDate (Date date) {
        this.date = date;
    }

    /**
     * sets the agence parameter of a booking
     * @param agence
     */
    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    /**
     * sets the buyer parameter of a booking
     * @param buyer
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    /**
     * sets the property parameter of a booking
     * @param property
     */
    public void setProperty(Property property) {
        this.property = property;
    }
    
    




}
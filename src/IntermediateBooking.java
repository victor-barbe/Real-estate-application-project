
import java.util.Date;
import java.util.ArrayList; 

/**
 * Class IntermediateBooking, makes the link between the booking class and the data base because can't registrate type buyer in sql
 * @author User
 */
public class IntermediateBooking {
    private Date date; 
    private int buyerID; 
    private int propertyID; 

    /**
     * Constructor, takes the date and the buyer and property ID to make an intermediate booking
     * @param date
     * @param buyerID
     * @param propertyID
     */
    public IntermediateBooking(Date date, int buyerID, int propertyID) {
        this.date = date;
        this.buyerID = buyerID;
        this.propertyID = propertyID;
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
     * returns the ID number of the buyer
     * @return buyerID
     */
    public int getBuyerID() {
        return buyerID;
    }

    /**
     * returns the ID number of the Property
     * @return
     */
    public int getPropertyID() {
        return propertyID;
    }
    
    
}



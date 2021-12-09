

/**
 * Class IntermediateOffer, makes the link between the offer class and the data base because can't registrate type buyer in sql
 * @author User
 */
public class IntermediateOffer {
    private int offer; 
    private int buyerID; 
    private int propertyID; 

    /**
     * constructor for intermediateOffer with the offer price, buyer and property ID
     * @param offer
     * @param buyerID
     * @param propertyID
     */
    public IntermediateOffer(int offer, int buyerID, int propertyID) {
        this.offer = offer;
        this.buyerID = buyerID;
        this.propertyID = propertyID;
    }

    
    // GETTERS 

    /**
     * returns the price of the offer made by the buyer
     * @return offer
     */
    
    public int getOffer() {
        return offer;
    }

    /**
     * returns the ID number of the buyer
     * @return buyerID
     */
    public int getBuyerID() {
        return buyerID;
    }

    /**
     * returns the ID number of the property
     * @return propertyID
     */
    public int getPropertyID() {
        return propertyID;
    }
    
    // SETTERS 

    /**
     * sets the offer parameter of the intermediate offer
     * @param offer
     */

    public void setOffer(int offer) {
        this.offer = offer;
    }

    /**
     * sets the ID of the buyer parameter of the intermediate offer
     * @param buyerID
     */
    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    /**
     * sets the Property ID number parameter of the intermediate offer
     * @param propertyID
     */
    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }
    
    
}

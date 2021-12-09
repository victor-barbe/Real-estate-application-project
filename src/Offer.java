

/**
 * Class Offer to create an Offer with a Price form a buyer and inform the Seller of this offer, using the Agence class
 * @author User
 */
public class Offer {
    
    private Property property; 
    private Buyer buyer; 
    private Agence agence; 
    private int buyerOffer; 

    /**
     * Constructor with the concerned Property and the Buyer who makes the Offer. Agence for global linking 
     * @param property
     * @param buyer
     * @param agence
     * @param buyerOffer
     */
    public Offer(Property property, Buyer buyer, Agence agence, int buyerOffer) {
        this.property = property;
        this.buyer = buyer;
        this.agence = agence;
        this.buyerOffer = buyerOffer;
    }
    
    /** Constructor without agence
     *
     * @param property
     * @param buyer
     * @param buyerOffer
     */
    public Offer(Property property, Buyer buyer, int buyerOffer){
        this.property = property; 
        this.buyer = buyer; 
        this.buyerOffer = buyerOffer; 
    }

    /**
     * returns the property object
     * @return property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * returns the buyer object
     * @return buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * returns the agence object
     * @return agence
     */
    public Agence getAgence() {
        return agence;
    }

    /**
     * returns the value of the buyer's offer
     * @return buyerOffer
     */
    public int getBuyerOffer() {
        return buyerOffer;
    }

    /**
     * sets the property parameter of the offer
     * @param property
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * sets the buyer parameter of the offer
     * @param buyer
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    /**
     * sets the agence parameter of the offer
     * @param agence
     */
    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    /**
     * sets the value of the buyer's offer parameter of the offer
     * @param buyerOffer
     */
    public void setBuyerOffer(int buyerOffer) {
        this.buyerOffer = buyerOffer;
    }
    
    
    
}

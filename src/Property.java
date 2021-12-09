    

/**
 * Property class to create property objets to add then to the database
 * @author User
 */
public class Property {
    private String adress; 
    private String type; 
    private String proprietaire; 
    private int price; 
    private int ID; 
    private int size; 
    private int bedrooms; 
   
    /** 
     * Constructor to create property object with every parameter linked to the property
     * @param adress
     * @param size
     * @param bedrooms
     * @param price
     * @param ID
     * @param proprietaire
     * @param type
     */
    public Property(String adress, int size, int bedrooms, int price, int ID, String proprietaire, String type) {
        this.adress = adress;
        this.bedrooms = bedrooms;
        this.price = price;
        this.ID = ID;
        this.size = size;
        this.type = type; 
        this.proprietaire = proprietaire; 
                
    }

    // Getters 

    /**
     * return the adress of the property        
     * @return adress
     */
    
    public String getAdress() {
        return adress;
    }

    /**
     * returns the number of bedrooms of the property
     * @return bedrooms
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * returns the price value of the property
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * returns the ID number of the property
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * returns the Size number in square meters of the property
     * @return size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * returns the type of property (house, flat..) of the property
     * @return type
     */
    public String getType(){
        return type; 
    }
    
    /**
     * returns the name of the owner of the property
     * @return proprietaire
     */
    public String getProprio(){
        return proprietaire; 
    }

    // Setters 

    /**
     * sets the Adress parameter of the property
     * @param adress
     */
    
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * sets the number of rooms of the property
     * @param bedrooms
     */
    public void setFeatures(String bedrooms) {
        this.bedrooms = this.bedrooms;
    }

    /**
     * sets the price value of the property
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * sets the ID number of the property
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * sets the size value of the property in square meters
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
}

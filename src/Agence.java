
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Agence, makes the link between all the different classes in the project, so we can have access to everyneeded information 
 * @author User
 */
public class Agence {

    private ArrayList<Property> arraylistProperty = new ArrayList<>();
    private ArrayList<Agent> arraylistAgent = new ArrayList<>();
    private ArrayList<Buyer> arraylistBuyer = new ArrayList<>();
    private ArrayList<Seller> arraylistSeller = new ArrayList<>();
    
    private ArrayList<Booking> arraylistBooking = new ArrayList<>();
    private ArrayList<IntermediateBooking> arraylistIntermediateBooking = new ArrayList<>();
    
    private ArrayList<Offer> arraylistOffer = new ArrayList<>();
    private ArrayList<IntermediateOffer> arraylistIntermediateOffer = new ArrayList<>();
    
    
    
    
    private Connexion connexion; 

    /**
     *Constructor, to connect the database and the program, fill the arraylist with the data
     * @param connexion
     * @throws SQLException
     * @throws ParseException
     */
    public Agence(Connexion connexion) throws SQLException, ParseException {
        arraylistProperty = connexion.remplirChampsProperty();
        arraylistAgent = connexion.remplirChampsAgent();
        arraylistBuyer = connexion.remplirChampsBuyer();
        arraylistSeller = connexion.remplirChampsSeller();
        arraylistIntermediateBooking = connexion.remplirChampsIntermediateBooking();
        arraylistIntermediateOffer = connexion.remplirChampsIntermediateOffer();
        this.connexion = connexion; 

        // Remplissage de arraylistBooking (complexe, étant donné que Booking a des types inconnus de la SQL en attributs) 
        
        int pInitID; 
        int bInitID; 
        
        ArrayList<Buyer> buyerInitList = new ArrayList<>();
        ArrayList<Property> propertyInitList = new ArrayList<>();
        
        for(int i = 0; i < arraylistIntermediateBooking.size(); ++i){
            //String dateInitString = String.valueOf(simpleFormatInit1.format(arraylistIntermediateBooking.get(i).getDate()) + simpleFormatInit2.format(arraylistIntermediateBooking.get(i).getDate()) + simpleFormatInit3.format(arraylistIntermediateBooking.get(i).getDate()));
            Date sDate1 = arraylistIntermediateBooking.get(i).getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            
            pInitID = arraylistIntermediateBooking.get(i).getPropertyID();
            bInitID = arraylistIntermediateBooking.get(i).getBuyerID();
            
            for(int j = 0; j < arraylistBuyer.size(); ++j){
                if(arraylistBuyer.get(j).getID() == bInitID){
                    buyerInitList.add(new Buyer(arraylistBuyer.get(j).getPrenom(), arraylistBuyer.get(j).getNom(), arraylistBuyer.get(j).getID(), arraylistBuyer.get(j).getID()));
                }
            }
            
            for(int k = 0; k < arraylistProperty.size(); k++){
                if(arraylistProperty.get(k).getID() == pInitID){
                    propertyInitList.add(new Property(arraylistProperty.get(k).getAdress(), arraylistProperty.get(k).getSize(), arraylistProperty.get(k).getBedrooms(), arraylistProperty.get(k).getPrice(), arraylistProperty.get(k).getID(), arraylistProperty.get(k).getProprio(), arraylistProperty.get(k).getType()));
                }
            }
            arraylistBooking.add(new Booking(sDate1, buyerInitList.get(i), propertyInitList.get(i)));
        }
        System.out.println("Voici le nombre de bookings à l'ouverture du programme : " + arraylistBooking.size());
        
        
        // Remplissage de arraylistOffer, même méthode que pour arraylistBooking
        
        int pInitID2; 
        int bInitID2; 
        
        ArrayList<Buyer> buyerInitList2 = new ArrayList<>(); 
        ArrayList<Property> propertyInitList2 = new ArrayList<>(); 
        
        for(int a = 0; a < arraylistIntermediateOffer.size(); ++a){
            pInitID2 = arraylistIntermediateOffer.get(a).getPropertyID();
            bInitID2 = arraylistIntermediateOffer.get(a).getBuyerID();
            
            for(int b = 0; b < arraylistBuyer.size(); ++b){
                if(arraylistBuyer.get(b).getID() == bInitID2){
                    Buyer newBuyer2; 
                    newBuyer2 = arraylistBuyer.get(b); 
                    buyerInitList2.add(newBuyer2); 
                }
            }
            for(int c = 0; c < arraylistProperty.size(); ++c){
                if(arraylistProperty.get(c).getID() == pInitID2){
                    Property newProperty2; 
                    newProperty2 = arraylistProperty.get(c);
                    propertyInitList2.add(newProperty2);
                }
            }
            arraylistOffer.add(new Offer(propertyInitList2.get(a), buyerInitList2.get(a), arraylistIntermediateOffer.get(a).getOffer()));
        }
    }

    /**
     * Used to create a new offer and put in in the data base, checks if the buyer already made an offer
     * @param buyerID
     * @param propertyID
     * @param amount
     * @param agence
     * @throws SQLException
     */
    public void registrateNewOffer(int buyerID, int propertyID, int amount, Agence agence) throws SQLException {
        int counter = 0; 
        ArrayList<IntermediateOffer> intermediateList = new ArrayList<>();
        int pID; 
        int bID; 
        
        for(int i = 0; i < arraylistOffer.size(); ++i){
            if(arraylistOffer.get(i).getBuyer().getID() == buyerID && arraylistOffer.get(i).getProperty().getID() == propertyID){
                counter = 1; 
                System.out.println("Il y a déjà une offre pour cette propriété");
            }
        }
        if(counter == 0){
            int primary = 1 + (int)(Math.random() * (10000));
            connexion.getStmt().executeUpdate("INSERT INTO offer (offer, buyerID, propertyID, number)" + "VALUES (" + amount + "," + buyerID + "," + propertyID + "," + primary +");");
            arraylistOffer.clear();
            intermediateList = connexion.remplirChampsIntermediateOffer(); 
            
            ArrayList<Buyer> buyerList = new ArrayList<>(); 
            ArrayList<Property> propertyList = new ArrayList<>(); 
            
            for(int j = 0; j < intermediateList.size(); ++j){
                bID = intermediateList.get(j).getBuyerID();
                pID = intermediateList.get(j).getPropertyID();
                
                for(int k = 0; k < arraylistBuyer.size(); ++k){
                    if(arraylistBuyer.get(k).getID() == bID){
                        Buyer newBuyer;
                        newBuyer = arraylistBuyer.get(k);
                        buyerList.add(newBuyer); 
                    }
                }
                for(int m = 0; m < arraylistProperty.size(); ++m){
                    if(arraylistProperty.get(m).getID() == pID){
                        Property newProperty; 
                        newProperty = arraylistProperty.get(m); 
                        propertyList.add(newProperty); 
                    }
                }
                for(int n = 0; n < buyerList.size(); ++n){
                    arraylistOffer.add(new Offer(propertyList.get(n), buyerList.get(n), agence, amount));
                }
            }
        }
        
    }

    /**
     * To create a new booking in the database, checks if the buyer already make a booking for this property
     * @param date
     * @param buyerID
     * @param propertyID
     * @param agence
     * @throws SQLException
     * @throws ParseException
     */
    public void registrateNewBooking(Date date, int buyerID, int propertyID, Agence agence) throws SQLException, ParseException{
        int counter = 0; 
        ArrayList<IntermediateBooking> intermediateList = new ArrayList<>();
        int pID; 
        int bID; 
        SimpleDateFormat simpleFormat1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat simpleFormat2 = new SimpleDateFormat("MM");
        SimpleDateFormat simpleFormat3 = new SimpleDateFormat("dd");

        String dateString = String.valueOf(simpleFormat1.format(date) + simpleFormat2.format(date) + simpleFormat3.format(date));
        
        for(int i = 0; i < arraylistBooking.size(); ++i){
            if(arraylistBooking.get(i).getBuyer().getID() == buyerID && arraylistBooking.get(i).getProperty().getID() == propertyID){
                System.out.println("Il y a déjà une réservation au nom de : " + arraylistBooking.get(i).getBuyer().getNom() + " pour visiter la propriété située au : " + arraylistBooking.get(i).getProperty().getAdress());
                counter = 1; 
            }
        }
        if(counter == 0){
            //int primary = arraylistIntermediateBooking.size() + 1;
            int primary = 1 + (int)(Math.random() * (10000));
            System.out.println("INSERT INTO booking (date, buyerID, propertyID)" + "VALUES(" + dateString + "," + buyerID + "," + propertyID + ");");
            connexion.getStmt().executeUpdate("INSERT INTO booking (date, buyerID, propertyID, number)" + "VALUES(" + dateString + "," + buyerID + "," + propertyID + "," + primary + ");");
            arraylistBooking.clear();
            intermediateList = connexion.remplirChampsIntermediateBooking();
            ArrayList<Buyer> buyerList = new ArrayList<>();
            ArrayList<Property> propertyList = new ArrayList<>();
            
            for(int j = 0; j < intermediateList.size(); ++j){
                pID = intermediateList.get(j).getPropertyID();
                bID = intermediateList.get(j).getBuyerID();
                System.out.println("Property ID : " + pID);
                System.out.println("Buyer ID : " + bID);
                System.out.println("Date : " + intermediateList.get(j).getDate());
                for(int k = 0; k < arraylistBuyer.size(); ++k){
                    if(arraylistBuyer.get(k).getID() == bID){
                        buyerList.add(new Buyer(arraylistBuyer.get(k).getPrenom(), arraylistBuyer.get(k).getNom(), arraylistBuyer.get(k).getID(), arraylistBuyer.get(k).getMDP()));
                    }
                }
                for(int m = 0; m < arraylistProperty.size(); ++m){
                    if(arraylistProperty.get(m).getID() == pID){
                        propertyList.add(new Property(arraylistProperty.get(m).getAdress(), arraylistProperty.get(m).getSize(), arraylistProperty.get(m).getBedrooms(), arraylistProperty.get(m).getPrice(), arraylistProperty.get(m).getID(), arraylistProperty.get(m).getProprio(), arraylistProperty.get(m).getType()));
                    }
                }
            }
            System.out.println("Taille property : " + propertyList.size());
            for(int n = 0; n < buyerList.size(); ++n){
                arraylistBooking.add(new Booking(intermediateList.get(n).getDate(), agence, buyerList.get(n), propertyList.get(n)));
            }
               // return true;           
        }
        // return false; 
    }

    /**
     * To create a new Buyer in the data base, checks if there isnt already a buyer with this ID (primary key)
     * @param name
     * @param surname
     * @param ID
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean registrateNewBuyer(String name, String surname, int ID, int password) throws SQLException{
        int counter = 0; 
        for(int i = 0; i < arraylistBuyer.size(); ++i){
            if(arraylistBuyer.get(i).getID() == ID){
                System.out.println("Cet identifiant : " + ID + "est déjà utilisé ");
                counter = 1; 
            }
        }
        
        if(counter == 0){
            connexion.getStmt().executeUpdate("INSERT INTO buyer (Nom, Prenom, ID, MDP)" + "VALUES('" + name + "','" + surname + "'," + ID +"," + password + ");"); 
            arraylistBuyer.clear();
            arraylistBuyer = connexion.remplirChampsBuyer();
            System.out.println("Taille : " + arraylistBuyer.size());
            return true;
        }
        return false;      
    }
    
    /**
     *To create a new seller in the data base, checks if there isnt already a seller with this ID (primary key)
     * @param name
     * @param surname
     * @param ID
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean registrateNewSeller(String name, String surname, int ID, int password) throws SQLException{
        int counter = 0; 
        for(int i = 0; i < arraylistSeller.size(); ++i){
            if(arraylistSeller.get(i).getID() == ID){
                System.out.println("Cet identifiant : " + ID + "est déjà utilisé ");
                counter = 1; 
            }
        }
        
        if(counter == 0){
            connexion.getStmt().executeUpdate("INSERT INTO seller (Nom, Prenom, ID, MDP)" + "VALUES('" + name + "','" + surname + "'," + ID +"," + password + ");"); 
            arraylistSeller.clear();
            arraylistSeller = connexion.remplirChampsSeller();
            System.out.println("Taille : " + arraylistSeller.size());
            return true;
        }
        return false;      
    }
    
    /**
     *To create a new property and put it in the data base
     * @param adress
     * @param size
     * @param numberRooms
     * @param price
     * @param ID
     * @param owner
     * @param type
     * @throws SQLException
     */
    public void registrateNewProperty (String adress, int size, int numberRooms, int price, int ID, String owner, String type) throws SQLException
    {
        connexion.getStmt().executeUpdate("INSERT INTO property (Adress, Size, nbChambres, Price, ID, Propriétaire, Type)" + "VALUES ('" + adress + "'," + size + "," + numberRooms + "," + price + "," + ID + ",'" + owner + "','" + type + "');");
        arraylistProperty.clear();
        arraylistProperty = connexion.remplirChampsProperty();
        
    }
    
    /**
     * To delete a property from the data base (used if the seller or agent wants to delete a property)
     * @param identifiant
     * @throws SQLException
     * @throws ParseException
     */
    public void deleteProperty(int identifiant) throws SQLException, ParseException{
            connexion.getStmt().executeUpdate("DELETE FROM property WHERE ID = " + identifiant);
            connexion.getStmt().executeUpdate("DELETE FROM booking WHERE propertyID = " + identifiant);
            connexion.getStmt().executeUpdate("DELETE FROM offer WHERE propertyID = " + identifiant);
            arraylistProperty.clear();
            arraylistProperty = connexion.remplirChampsProperty();
            resetBookings();
            resetOffers();
            System.out.println("Taille property : " + arraylistProperty.size());
            System.out.println("Taille bookings : " + arraylistBooking.size());
            System.out.println("Taille offers : " + arraylistOffer.size());
            
            // Coder pour actualiser les bookings et les offres 
        }
    
    /**
     *To delete a booking from the data base(if the seller doesnt want a viewing on a day)
     * @param buyerID
     * @param propertyID
     * @throws SQLException
     * @throws ParseException
     */
    public void deleteBooking(int buyerID, int propertyID) throws SQLException, ParseException{
        
        /*
        int number = 0; 
        
        ResultSet rset;

        rset = connexion.getStmt().executeQuery("select * from booking");

        for(int i = 0; i < arraylistBooking.size(); ++i){
            if(arraylistBooking.get(i).getBuyer().getID() == buyerID && arraylistBooking.get(i).getProperty().getID() == propertyID){
                 number = rset.getInt(4);
            }
        }
        */
        connexion.getStmt().executeUpdate("DELETE FROM booking WHERE buyerID = " + buyerID + " AND propertyID = " + propertyID);
        resetBookings();
    }

    /**
     *To reset the booking made, clear array list and fills it again
     * @throws SQLException
     * @throws ParseException
     */
    public void resetBookings() throws SQLException, ParseException{
        int pInitID; 
        int bInitID; 
        
        arraylistBooking.clear();
        ArrayList<Buyer> buyerInitList = new ArrayList<>();
        ArrayList<Property> propertyInitList = new ArrayList<>();
        arraylistIntermediateBooking.clear();
        arraylistIntermediateBooking = connexion.remplirChampsIntermediateBooking();
        
        for(int i = 0; i < arraylistIntermediateBooking.size(); ++i){
            //String dateInitString = String.valueOf(simpleFormatInit1.format(arraylistIntermediateBooking.get(i).getDate()) + simpleFormatInit2.format(arraylistIntermediateBooking.get(i).getDate()) + simpleFormatInit3.format(arraylistIntermediateBooking.get(i).getDate()));
            Date sDate1 = arraylistIntermediateBooking.get(i).getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            
            pInitID = arraylistIntermediateBooking.get(i).getPropertyID();
            bInitID = arraylistIntermediateBooking.get(i).getBuyerID();
            
            for(int j = 0; j < arraylistBuyer.size(); ++j){
                if(arraylistBuyer.get(j).getID() == bInitID){
                    buyerInitList.add(new Buyer(arraylistBuyer.get(j).getPrenom(), arraylistBuyer.get(j).getNom(), arraylistBuyer.get(j).getID(), arraylistBuyer.get(j).getID()));
                }
            }
            
            for(int k = 0; k < arraylistProperty.size(); k++){
                if(arraylistProperty.get(k).getID() == pInitID){
                    propertyInitList.add(new Property(arraylistProperty.get(k).getAdress(), arraylistProperty.get(k).getSize(), arraylistProperty.get(k).getBedrooms(), arraylistProperty.get(k).getPrice(), arraylistProperty.get(k).getID(), arraylistProperty.get(k).getProprio(), arraylistProperty.get(k).getType()));
                }
            }
            arraylistBooking.add(new Booking(sDate1, buyerInitList.get(i), propertyInitList.get(i)));
        }
        
    }
    
    /**
     *To reset offers, clears arraylist and fills it again
     * @throws SQLException
     */
    public void resetOffers() throws SQLException{
        int pInitID2; 
        int bInitID2; 
        
        arraylistOffer.clear();
        ArrayList<Buyer> buyerInitList2 = new ArrayList<>(); 
        ArrayList<Property> propertyInitList2 = new ArrayList<>(); 
        
        arraylistIntermediateOffer.clear();
        arraylistIntermediateOffer = connexion.remplirChampsIntermediateOffer();
        
        for(int a = 0; a < arraylistIntermediateOffer.size(); ++a){
            pInitID2 = arraylistIntermediateOffer.get(a).getPropertyID();
            bInitID2 = arraylistIntermediateOffer.get(a).getBuyerID();
            
            for(int b = 0; b < arraylistBuyer.size(); ++b){
                if(arraylistBuyer.get(b).getID() == bInitID2){
                    Buyer newBuyer2; 
                    newBuyer2 = arraylistBuyer.get(b); 
                    buyerInitList2.add(newBuyer2); 
                }
            }
            for(int c = 0; c < arraylistProperty.size(); ++c){
                if(arraylistProperty.get(c).getID() == pInitID2){
                    Property newProperty2; 
                    newProperty2 = arraylistProperty.get(c);
                    propertyInitList2.add(newProperty2);
                }
            }
            arraylistOffer.add(new Offer(propertyInitList2.get(a), buyerInitList2.get(a), arraylistIntermediateOffer.get(a).getOffer()));
        }
    }
    
    /**
     * returns the list of properties
     * @return arrayListProperty
     */
    public ArrayList<Property> getArraylistProperty() {
        return arraylistProperty;
    }
    
    /**
     * returns the list of offers
     * @return arraylistOffer
     */
    public ArrayList<Offer> getArraylistOffer() {
        return arraylistOffer;
    }

    /**
     * returns the list of agents
     * @return arraylistAgent
     */
    public ArrayList<Agent> getArraylistAgent() {
        return arraylistAgent;
    }

    /**
     * returns the list of buyers
     * @return arraylistBuyer
     */
    public ArrayList<Buyer> getArraylistBuyer() {
        return arraylistBuyer;
    }

    /**
     * returns the list of sellers
     * @return arraylistSeller
     */
    public ArrayList<Seller> getArraylistSeller() {
        return arraylistSeller;
    }
    
    /**
     * returns the list of bookings
     * @return arraylistBooking
     */
    public ArrayList<Booking> getArraylistBooking() {
        return arraylistBooking;
    }
    
    /**
     * returns the list of intermediateBookings
     * @return arraylistIntermediateBooking
     */
    public ArrayList<IntermediateBooking> getArraylistIntermediateBooking(){
        return arraylistIntermediateBooking;
    }
}

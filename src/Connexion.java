
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver"); // A laisser

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:3306/bdd_projet"; // Modifier avec l'adresse de ma database, changer 3308 par 3306
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, "root", ""); // cette ligne fait la connexion avec la bdd

        // création d'un ordre SQL (statement)
            stmt = conn.createStatement();
    }
    
    /**
     *getter for statement
     * @return
     */
    public Statement getStmt(){
        return stmt; 
    }
    
    /**
     *This method is used to fill the property table in the database
     * @return propertyList
     * @throws SQLException
     */
    public ArrayList<Property> remplirChampsProperty() throws SQLException{
        rset = stmt.executeQuery("select * from property");
        ArrayList<Property> propertyList = new ArrayList<>();
        
        while(rset.next()){
            String adress = rset.getString(1);
            int bedrooms = rset.getInt(3); 
            String type = rset.getString(7); 
            String proprietaire = rset.getString(6); 
            int ID = rset.getInt(5);
            int price = rset.getInt(4);
            int size = rset.getInt(2); 
            propertyList.add(new Property(adress, size, bedrooms, price, ID, proprietaire, type));
        }
        return propertyList;
              
    }
    
    /**
     *This method is used to fill the agent table in the database
     * @return agentList
     * @throws SQLException
     */
    public ArrayList<Agent> remplirChampsAgent() throws SQLException{
        rset = stmt.executeQuery("select * from agent");
        ArrayList<Agent> agentList = new ArrayList<>();
        
        while(rset.next()){
            String nom = rset.getString(1); 
            String prenom = rset.getString(2); 
            int ID = rset.getInt(3); 
            int MDP = rset.getInt(4);
            agentList.add(new Agent(prenom, nom, ID, MDP));            
        }
        return agentList; 
    }
    
    /**
     * This method is used to fill the buyer table in the database
     * @return buyerList
     * @throws SQLException
     */
    public ArrayList<Buyer> remplirChampsBuyer() throws SQLException{
        rset = stmt.executeQuery("select * from buyer");
        ArrayList<Buyer> buyerList = new ArrayList<>();
         
        while(rset.next()){
            String nom = rset.getString(1); 
            String prenom = rset.getString(2); 
            int ID = rset.getInt(3);
            int MDP = rset.getInt(4);
            buyerList.add(new Buyer(nom, prenom, ID, MDP));
        }
        
        return buyerList; 
    }
    
    /**
     *This method is used to fill the booking table in the database
     * @return intermediateBookingList
     * @throws SQLException
     * @throws ParseException
     */
    public ArrayList<IntermediateBooking> remplirChampsIntermediateBooking() throws SQLException, ParseException{
        rset = stmt.executeQuery("select * from booking");
        ArrayList<IntermediateBooking> intermediateBookingList = new ArrayList<>();
        
        while(rset.next()){
           
            String sDate1 = rset.getString(1);
            System.out.println("Taille : " + sDate1.length());
            String annee1 = sDate1.substring(0, 4);
            String mois1 = sDate1.substring(4, 6);
            String jour1 = sDate1.substring(6);
            sDate1 = jour1 + "/" + mois1 + "/" + annee1;
            
            System.out.println("année : " + annee1 + " " + mois1 + " " + jour1);
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter1.parse(sDate1);
            System.out.println("la date voulue " + date);
            //Date date = rset.getDate(1);
            int buyerID = rset.getInt(2);
            int propertyID = rset.getInt(3);
            intermediateBookingList.add(new IntermediateBooking(date, buyerID, propertyID));
        }
        return intermediateBookingList;
    }
    
    /**
     *This method is used to fill the offer table in the database
     * @return intermediateOfferList
     * @throws SQLException
     */
    public ArrayList<IntermediateOffer> remplirChampsIntermediateOffer() throws SQLException {
        rset = stmt.executeQuery("select * from offer");
        ArrayList<IntermediateOffer> intermediateOfferList = new ArrayList<>();
        
        while(rset.next()){
            int amount = rset.getInt(1); 
            int bID = rset.getInt(2); 
            int pID = rset.getInt(3); 
            intermediateOfferList.add(new IntermediateOffer(amount, bID, pID));
        }
        return intermediateOfferList;
    }
    
    /**
     * This method is used to fill the seller table in the database
     * @return sellerList
     * @throws SQLException
     */
    public ArrayList<Seller> remplirChampsSeller() throws SQLException{
        rset = stmt.executeQuery("select * from seller");
        ArrayList<Seller> sellerList = new ArrayList<>(); 
        
        while(rset.next()){
            String nom = rset.getString(1); 
            String prenom = rset.getString(2); 
            int ID = rset.getInt(3);
            int MDP = rset.getInt(4);
            sellerList.add(new Seller(prenom, nom, ID, MDP));
        }
        return sellerList; 
    }
    
     
    
    
    
    
    
    
    
    
    

    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
}



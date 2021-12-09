
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class Seller, used for the owners who want to sell a property, extends abstract class personne
 * @author Pierre-Louis
 */
public class Seller extends Personne{

    //public ArrayList<Property> myProperty = new ArrayList(null);

    /**
     * Constructor uses the mother class personne
     * @param prenom
     * @param nom
     * @param ID
     * @param MDP
     */
    
    private ArrayList<Booking> confirmedBookings = new ArrayList<>();
    
    public Seller(String prenom, String nom, int ID, int MDP) {
        super(prenom, nom, ID, MDP);
    }

    public ArrayList<Booking> getConfirmedBookings() {
        return confirmedBookings;
    }
    
<<<<<<< HEAD
  
=======
   
>>>>>>> master
   

}

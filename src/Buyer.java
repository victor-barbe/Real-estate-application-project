import java.util.ArrayList; 

/**
 * Class Buyer extends abstract class personne, then used to make bookings, offers...
 * @author User
 */
public class Buyer extends Personne{

    /**
     *Constructor uses mother class's constructor to create a buyer object with name, first name, Id and password
     * @param prenom
     * @param nom
     * @param ID
     * @param MDP
     */
    public Buyer(String prenom, String nom, int ID, int MDP) {
        super(prenom, nom, ID, MDP);
    }
    
      
}
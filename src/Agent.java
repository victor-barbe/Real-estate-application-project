import java.util.ArrayList; 
import java.util.Scanner; 

/**
 * Class Agent, used for the employees of the compagny, extends abstract class personne
 * @author User
 */
public class Agent extends Personne{

    /**
     * Constructor uses the mother class personne
     * @param prenom
     * @param nom
     * @param ID
     * @param MDP
     */
    public Agent(String prenom, String nom, int ID, int MDP) {
        super(prenom, nom, ID, MDP);
    }
   
    
}

import java.util.ArrayList; 

/**
 * Abstract class, model for all the classes about a Personne (seller, buyer, agent ...)
 * @author User
 */
public abstract class Personne {
    private String prenom; 
    private String nom; 
    private int ID; 
    private int MDP; 

    /**
     * Model constructor for all the daughter classes with essential information about the personne
     * @param prenom
     * @param nom
     * @param ID
     * @param MDP
     */
    public Personne(String prenom, String nom, int ID, int MDP) {
        this.prenom = prenom;
        this.nom = nom;
        this.ID = ID;
        this.MDP = MDP;
    }

    /**
     * returns the first name of the person
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * returns the name of the person
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * returns the ID number of the person
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * returns the password number of the person
     * @return MDP
     */
    public int getMDP() {
        return MDP;
    }

    /**
     * sets the first name parameter of the person
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * sets the name parameter of the person
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * sets the ID number parameter of the person
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * sets the password number parameter of the person
     * @param MDP
     */
    public void setMDP(int MDP) {
        this.MDP = MDP;
    }
    

}
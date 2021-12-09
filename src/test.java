import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList; 
import java.util.Scanner; 

/**
 * Test class where the main is located
 * @author User
 */
public class test {

    /**
     * Main to create the first window and launch the program
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException{
       
    Connexion connexion = new Connexion("property", "root", ""); 
    Agence agence = new Agence(connexion);
    
    Identification identification = new Identification(agence); 
    identification.setVisible(true);
    
    }
}

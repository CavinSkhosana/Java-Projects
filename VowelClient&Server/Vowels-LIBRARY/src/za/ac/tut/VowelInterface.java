// Student no : 220452980
// CS SKHOSANA


package za.ac.tut;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cavin
 */
public interface VowelInterface {
      
    public void Add(Vowel vowel) throws SQLException;
  
   public List<Vowel> getEverything(Vowel vowel) throws SQLException;
      
            
           
}

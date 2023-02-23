// Student no : 220452980
// CS SKHOSANA


package za.ac.tut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cavin
 */
public class VowelManager implements  VowelInterface{
    
    private Connection connection;

    public VowelManager() {
    }
    
    

    public VowelManager(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
    
    String ADDsql = "INSERT INTO TBL "
            + "VALUES(?,?,?,?,?,?,?)";
    
       
        
            String Everythingsql = "SELECT * FROM TBL";

    @Override
    public void Add(Vowel vowel) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(ADDsql);
           
            ps.setString(1, vowel.getWord());
            ps.setInt(2, vowel.getAs());
            ps.setInt(3, vowel.getEs());
            ps.setInt(4, vowel.getIs());
            ps.setInt(5, vowel.getOs());
            ps.setInt(6, vowel.getUs());
            
            Timestamp ts = Timestamp.from(Instant.now());
         ps.setTimestamp(7, ts);
         
         ps.executeUpdate();
    }

  
    @Override
    public List<Vowel> getEverything(Vowel vowel) throws SQLException {
               PreparedStatement ps = connection.prepareStatement(Everythingsql);
                
                 List<Vowel> myList = new ArrayList<>();
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
              
            String word = rs.getString("WORD");
             int A = rs.getInt("A");
            int E = rs.getInt("E");
            int I = rs.getInt("I");
            int O = rs.getInt("O");
            int U = rs.getInt("U");
          Timestamp ts = rs.getTimestamp("TIMESTAMP");
            
            vowel = new Vowel(word,A,E,I,O,U,ts);
            
           myList.add(vowel);
               
    }
      return myList;
}
}

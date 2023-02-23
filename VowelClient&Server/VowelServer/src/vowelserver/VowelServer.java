// Student no : 220452980
// CS SKHOSANA

package vowelserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import za.ac.tut.VowelManager;
import za.ac.tut.VowelThread;

/**
 *
 * @author Cavin
 */
public class VowelServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
         ServerSocket s = null;
        Socket socket = null;
        
        String dbURL = "jdbc:derby://localhost:1527/VowelDB ";
        String username = "app";
        String password = "123";
        
        Connection con;
        VowelManager vm;
        
        try{
             con = DriverManager.getConnection(dbURL, username, password);
              vm = new VowelManager(con);
            s = new ServerSocket(2022);
             System.out.println("Start server: "+s);
             
          
          
               
                  
                    socket = s.accept();
             System.out.println("Establish connection: "+socket);
             
             
             VowelThread vt= new VowelThread(socket,vm);
        
        } catch(IOException ioe){
        
          System.out.println(ioe.getMessage());
        }
        
    }
    
}

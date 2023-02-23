
// Student no : 220452980
// CS SKHOSANA
package vowelclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.Vowel;
import za.ac.tut.VowelManager;

/**
 *
 * @author Cavin
 */
public class VowelClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        InetAddress addr = null;
        Socket socket = null;
        
           BufferedReader in = null;

        PrintWriter out = null;

        Scanner ke = new Scanner(System.in);
        
         String dbURL = "jdbc:derby://localhost:1527/VowelDB ";
        String username = "app";
        String password = "123";
        
        Connection con;
        
        Vowel vv = new Vowel();
       
        VowelManager vm;
        
        
        try{
             con = DriverManager.getConnection(dbURL, username, password);
              vm = new VowelManager(con);
                 addr = InetAddress.getByName("192.168.56.1");
                  System.out.println("Address: "+addr);
                  
                  socket = new Socket(addr,2022);
                  
                  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                  
                  
                  int option = getOption();
                  String data = "";
                  
                  while(option!=3){
                  
                    switch(option){
                        case 1 :
                            data = "1";
                                break;
                                
                        case 2 : 
                            
                             List<Vowel> myList = vm.getEverything(vv);
                             
                             display(myList);
                            break;
                          
                        default:
                              System.out.println("Wrong option");
                                                        
                    }
                         
                    out.println(data);
                    
                    String dataServer = in.readLine();
                    
                    System.out.println(dataServer);
                     String word = ke.next();
                     
                     out.println(word);
                      option = getOption();
                  }
                  
                   out.println("END");
                    
                   
                 
        }catch(UnknownHostException ex){
          
            System.out.println(ex.getMessage());
        
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
        } finally {

            try {
                System.out.println("Closing....");
                socket.close();

            } catch (IOException ioe) {

                System.out.println(ioe.getMessage());

            }
        }
    }

    private static int getOption() {
            Scanner ke = new Scanner(System.in);
            
            System.out.println("SELECT BELOW : \n"
                    + "1. Add a word to check vowels \n"
                    
                    + "2. Get all the word with its vowels \n"
                    + "3. Exit \n");
            
            int option = ke.nextInt();
            
            return option;
            
    } 

 

    private static void display(List<Vowel> myList) {

          for(int x = 0; x<myList.size();x++){
          
            System.out.println("Word: "+myList.get(x).getWord());
            System.out.println("As "+myList.get(x).getAs());
            System.out.println("Es "+myList.get(x).getEs());
            System.out.println("Is "+myList.get(x).getEs());
            System.out.println("Os "+myList.get(x).getOs());
            System.out.println("Us "+myList.get(x).getUs());
                   
                    
            
          }
    }
    
}

// Student no : 220452980
// CS SKHOSANA

package za.ac.tut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cavin
 */
public class VowelThread extends Thread {
      
    private VowelManager vm;
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out;
    
    

    public VowelThread(Socket socket,VowelManager vm) throws IOException {
        this.socket = socket;
        this.vm=vm;
        
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        start();
    }
    
    
    @Override
    public void run(){
        
        int counterA =0;
        int counterE =0;
        int counterI =0;
        int counterO =0;
        int counterU =0;
        
        char currentChar;
      
        try {
            String data = in.readLine();
             
          //System.out.println(data);
            
          while(data!="END"){
             
           String userWordRequest = "Enter the name: ";
            out.println(userWordRequest);
            
            String word = in.readLine();
                 
                 
               if(data.equals("1")){
                      
         for(int x= 0;x<word.length();x++)
        {
          currentChar = word.charAt(x);
          
          if(currentChar == 'a' || currentChar == 'A')
          {
            counterA++;
          }
          
          if(currentChar == 'e' || currentChar == 'E')
          {
             counterE++;
          }
          
            if(currentChar == 'i' || currentChar == 'I')
          {
             counterI++;
          }
            
              if(currentChar == 'o' || currentChar == 'O')
          {
             counterO++;
          }
              
                if(currentChar == 'u' || currentChar == 'U')
          {
             counterU++;
          }
        
          
          
        } 
      
         System.out.println("There are "+counterA+" A's");
          System.out.println("There are "+counterE+" E's");
            System.out.println("There are "+counterI+" I's");
          System.out.println("There are "+counterO+" O's");
                   System.out.println("There are "+counterU+" U's");
          
               }
             
               Vowel vv = new Vowel(word,counterA,counterE,counterI,counterO,counterU);
               vm.Add(vv);
                
               
                data = in.readLine();
             }
            
            
        } catch (IOException ex) {
              System.out.println(ex.getMessage());

        } catch (SQLException ex) {
                   System.out.println(ex.getMessage());
        }
    
    }
} 

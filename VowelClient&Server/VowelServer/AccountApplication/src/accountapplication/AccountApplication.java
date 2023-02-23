/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountapplication;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.Account;
import za.ac.tut.AccountManager;
import za.ac.tut.AccountThread;

/**
 *
 * @author Dumi
 */
public class AccountApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AccountManager am;
        Account account;
        Connection connection;
   
        
        
        String dbURL = "jdbc:derby://localhost:1527/AccountsDB";
        String username = "accounts";
        String password = "123";
        
        String balanceSQL =  "SELECT BALANCE "
                + "FROM ACCOUNT "
                + "WHERE ACCNO = ?";
        String updateSQL = "UPDATE ACCOUNT "
                + "SET BALANCE =? "
                + "WHERE ACCNO = ?";
         
        Thread at1, at2, at3, at4, at5;
       try{
           connection = DriverManager.getConnection(dbURL, username, password);
           am = new AccountManager(connection);
           
         at1 = new AccountThread(am,new Account(111),1,100,balanceSQL,updateSQL);
         at2 = new AccountThread(am,new Account(111),2,100,balanceSQL,updateSQL);
         at3 = new AccountThread(am,new Account(111),2,200,balanceSQL,updateSQL);
         at4 = new AccountThread(am,new Account(111),2,200,balanceSQL,updateSQL);
         at5 = new AccountThread(am,new Account(111),2,200,balanceSQL,updateSQL);
          
         at1.start();
          at2.start();
           at3.start();
            at4.start();
             at5.start();
       }catch(SQLException ex){
          System.out.println(ex.getMessage());
          
          //Logger.getLogger(AccountApplication.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}

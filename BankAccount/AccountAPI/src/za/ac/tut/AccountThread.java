/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dumi
 */
public class AccountThread extends Thread{
     
    private AccountManager am;
    Account account;
    int option;
    double amount;
    String balanceSQL,updateBalanceSQL;

    public AccountThread(AccountManager am, Account account, int option, double amount, String balanceSQL, String updateBalanceSQL) {
        this.am = am;
        this.account = account;
        this.option = option;
        this.amount = amount;
        this.balanceSQL = balanceSQL;
        this.updateBalanceSQL = updateBalanceSQL;
    }
    
    @Override
    public void run(){
       
        if(option == 1){
           try{
             am.deposit(account, amount, balanceSQL, updateBalanceSQL);
           }catch(SQLException ex){
               System.out.println(ex.getMessage());
           }
        }else {
           try{
            am.withdraw(account, amount, balanceSQL, updateBalanceSQL);
           
           }catch(SQLException ex){
               System.out.println(ex.getMessage());
        }
        }
    }
}

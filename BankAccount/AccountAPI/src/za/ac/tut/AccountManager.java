/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dumi
 */
public class AccountManager implements AccountManagerInterface {
    
    private Connection connection;

    public AccountManager(Connection connection) {
        this.connection = connection;
    }

  
    

    @Override
    public synchronized void deposit(Account account, Double amount, String balanceSQL,String updateBalanceSQL) throws SQLException {
        
        System.out.println(Thread.currentThread().getName()+": Deposit R"+amount);
        
        Double balance = getBalance(account,balanceSQL);
       balance = balance + amount;
        
        updateBalance(balance,account,updateBalanceSQL);
        
        System.out.println(Thread.currentThread().getName()+": deposit successful \n ");
        
    }

    @Override
    public synchronized Integer withdraw(Account account, Double reqAmount, String balanceSQL, String updateBalanceSQL) throws SQLException {
      
        System.out.println(Thread.currentThread().getName()+" Withdraw amount: R"+reqAmount);
        
        Double balance = getBalance(account, balanceSQL);
        System.out.println("Balance:R"+balance);
        
        if(balance >= reqAmount){
           balance = balance - reqAmount;
           
           updateBalance(balance, account, updateBalanceSQL);
           System.out.println(Thread.currentThread().getName() + ": withdrawal successfull.\n");
           
           return 1;
        } else{
             System.out.println(Thread.currentThread().getName()+" : Insufficient funds");
             return -1;
        }
        
    }

    private Double getBalance(Account account, String balanceSQL) throws SQLException{
           PreparedStatement ps = connection.prepareStatement(balanceSQL);
           
           ps.setInt(1, account.getAccNo());
           
           ResultSet rs = ps.executeQuery();
           
           Double balance = 5000.0;
           
           if(rs.next()){
              balance = rs.getDouble("Balance");
           }
           
           return balance;
    }

    private void updateBalance(Double balance, Account account, String updateBalanceSQL) throws SQLException {
        
          PreparedStatement ps = connection.prepareStatement(updateBalanceSQL);
          ps.setDouble(1, balance);
          ps.setInt(2, account.getAccNo());
          ps.executeUpdate();
    }

    
}

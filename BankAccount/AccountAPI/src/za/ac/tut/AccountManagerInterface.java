/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.SQLException;

/**
 *
 * @author Dumi
 */
public interface AccountManagerInterface {
     
    public void deposit(Account account, Double amount,String balanceSQL,String updateBalanceSQL) throws SQLException;
    
    public Integer withdraw(Account account,Double reqAmount,String balanceSQL, String updateBalanceSQL) throws SQLException;
}

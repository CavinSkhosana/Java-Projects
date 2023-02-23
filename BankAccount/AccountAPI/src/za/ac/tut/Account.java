/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

/**
 *
 * @author Dumi
 */
public class Account {
    
    private Integer AccNo;
    private Double balance;

    public Account() {
    }

    public Account(Integer AccNo, Double balance) {
        this.AccNo = AccNo;
        this.balance = balance;
    }

    public Account(Integer AccNo) {
        this.AccNo = AccNo;
    }

    public Integer getAccNo() {
        return AccNo;
    }

    public void setAccNo(Integer AccNo) {
        this.AccNo = AccNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
}

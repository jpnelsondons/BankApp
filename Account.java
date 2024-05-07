/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author jpnelson
 */
public class Account {
    private long acctNum = 0;
    private double balance = 0.0;
    private long customerID = 0;
    private boolean isCurrentAcct = true; //true is the value for a current account, false for Savings
    
    public void setIsCurrentAcct(boolean inC){
        isCurrentAcct = inC;
    }
    
    public boolean getIsCurrentAcct(){
        return isCurrentAcct;
    }
    
    public void setCustomerID(long inID){
        customerID = inID;
    }
    
    public long getCustomerID(){
        return customerID;
    }
    
    public void setAcctNum(long inAN){
        acctNum = inAN;
    }
    
    public long getAcctNum(){
        return acctNum;
    }
    
    public void setBalance(long inB){
        balance = inB;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public double deposit(){
        double dep = 0.0;
        
        return dep;
    }
    
    public double withdraw(){
        double wd = 0.0;
        
        return wd;
    }
    
    public double createTransaction(){
        double t = 0.0;
        
        return t;
    }
}

class CurrentAccount extends Account{
    public final String CURRENT = "CURRENT";
}

class SavingsAccount extends Account{
    private double intRate = 0.0;
    public final String SAVINGS = "SAVINGS";
    
    public void setIntRate(double inR){
        intRate = inR;
    }
    
    public double getIntRate(){
        return intRate;
    }
}

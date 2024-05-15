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
    private String isCurrentAcct = "current"; //default for a current account, other is for savings
    
    public Account(long inNum, long inCID, double inBal, String inCurr){
        acctNum = inNum;
        balance = inBal;
        customerID = inCID;
        isCurrentAcct = inCurr;
    }
    
    public Account(){
        acctNum = 0;
        balance = 0;
        customerID = 0;
        isCurrentAcct = "null";
    }
    
    public void setIsCurrentAcct(String inC){
        isCurrentAcct = inC;
    }
    
    public String getIsCurrentAcct(){
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
    
    public String toString(){
        String result = "";
        result = "Acct# \t" + acctNum + "\n" +
                "Customer # \t" + customerID + "\n" +
                "Balance: \t" + balance + "\n" +
                "Type: \t" + isCurrentAcct + "\n";
        return result;
    }
}
/*
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
*/
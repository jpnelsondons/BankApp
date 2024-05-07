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
public class Employee {
    private long ID = 0;
    private String name = "";
    private String role = "";
    
    public Employee(long inID, String inName, String inRole){
        ID = inID;
        name = inName;
        role = inRole;
    }
    
    public void setID(long inID){
        ID = inID;
    }
    
    public long getID(){
        return ID;
    }
    
    public void setName(String inName){
        name = inName;
    }
    
    public String getName(){
        return name;
    }
    
    public void setRole(String inRole){
        role = inRole;
    }
    
    public String getRole(){
        return role;
    }
    
    public String toString(){
        String result = ID + ", " + name + ", " + role;
        return result;
    }
}

class Manager extends Employee{
    
    public Manager(long inID, String inName, String inRole){
        super(inID, inName, inRole);
    }
    
    public long openAccount(long customerID){
        long acctNum = 0;
        
        return acctNum;
    }
    
    public long closeAccount(long acctID){
        return acctID;
    }            
}

class Teller extends Employee{
    
    public Teller(long inID, String inName, String inRole){
        super(inID, inName, inRole);
    }
    
    public void serveCustomer(long customerID){
        
    }
    
    public double reviewAccount(long acctID){
        long bal = 0;
        
        return bal;
    }
}

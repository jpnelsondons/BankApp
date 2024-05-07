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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.text.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class BankApp {

    public static void main(String[] args)
            throws Exception
    {
        MyFrame f = new MyFrame();
    }
}

class MyFrame
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton readF;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JTextField taID;
    private JLabel laID;
    private JTextField taAmt;
    private JLabel lAmt;
    private JRadioButton dep;
    private JRadioButton wd;
    private ButtonGroup rbTrans;
    private JLabel lTrans;
    private JButton subTrans;
    private ArrayList customers = new ArrayList();

    private String dates[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    private String months[]
            = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec"};
    private String years[]
            = {"1967", "1968", "1969", "1970",
            "1971", "1972", "1973", "1974",
            "1975", "1976", "1977", "1978",
            "1979", "1980", "1981", "1992",
            "1983", "1984", "1985", "1986",
            "1987", "1988", "1989", "1990",
            "1991", "1992", "1993", "1994",
            "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "2022"};
    ArrayList<String> strArr = new ArrayList<String>();
    ArrayList<BankAccount> arrAcc = new ArrayList<BankAccount>();
    //private String IDs[] = {"none"}; // = getIDs();
    private String strCustomers = "";

    // constructor, to initialize the components
    // with default values.
    public MyFrame() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        year.setSelectedIndex(years.length - 1);
        c.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 425);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 425);
        reset.addActionListener(this);
        c.add(reset);

        readF = new JButton("Read CSV");
        readF.setFont(new Font("Arial", Font.PLAIN, 15));
        readF.setSize(120, 20);
        readF.setLocation(200, 450);
        readF.addActionListener(this);
        c.add(readF);
        
        laID = new JLabel("Acct#");
        laID.setFont(new Font("Arial", Font.PLAIN, 20));
        laID.setSize(70, 30);
        laID.setLocation(90, 495);
        c.add(laID);
        
        taID = new JTextField();
        taID.setFont(new Font("Arial", Font.PLAIN, 15));
        taID.setSize(30, 20);
        taID.setLocation(150, 500);
        c.add(taID);
        
        lAmt = new JLabel("Amt");
        lAmt.setFont(new Font("Arial", Font.PLAIN, 20));
        lAmt.setSize(70, 30);
        lAmt.setLocation(190, 495);
        c.add(lAmt);
        
        taAmt = new JTextField();
        taAmt.setFont(new Font("Arial", Font.PLAIN, 15));
        taAmt.setSize(30, 20);
        taAmt.setLocation(240, 500);
        c.add(taAmt);

        tout = new JTextArea();
        tout.setText("tout");
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(420, 400);
        tout.setLocation(440, 100);
        tout.setLineWrap(false);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 530);
        c.add(res);
                
        lTrans = new JLabel("Transaction");
        lTrans.setFont(new Font("Arial", Font.PLAIN, 20));
        lTrans.setSize(120, 20);
        lTrans.setLocation(95, 480);
        c.add(lTrans);

        dep = new JRadioButton("Deposit");
        dep.setFont(new Font("Arial", Font.PLAIN, 15));
        dep.setSelected(true);
        dep.setSize(75, 20);
        dep.setLocation(210, 480);
        c.add(dep);

        wd = new JRadioButton("Withdraw");
        wd.setFont(new Font("Arial", Font.PLAIN, 15));
        wd.setSelected(false);
        wd.setSize(100, 20);
        wd.setLocation(290, 480);
        c.add(wd);

        rbTrans = new ButtonGroup();
        rbTrans.add(dep);
        rbTrans.add(wd);
        
        subTrans = new JButton("Transact");
        subTrans.setFont(new Font("Arial", Font.PLAIN, 15));
        subTrans.setSize(100, 20);
        subTrans.setLocation(300, 500);
        subTrans.addActionListener(this);
        c.add(subTrans);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(220, 75);
        resadd.setLocation(570, 175);
        resadd.setLineWrap(false);
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                String data
                        = "Name : "
                        + tname.getText() + "\n"
                        + "Mobile : "
                        + tmno.getText() + "\n";
                String csv  = "\n" + tname.getText() + "," + tmno.getText() + "," + (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/" + (String) year.getSelectedItem()  + "," + tadd.getText();
                if (male.isSelected())
                    data1 = "Gender : Male"
                            + "\n";
                else
                    data1 = "Gender : Female"
                            + "\n";
                String data2
                        = "DOB : "
                        + (String) date.getSelectedItem()
                        + "/" + (String) month.getSelectedItem()
                        + "/" + (String) year.getSelectedItem()
                        + "\n";

                String data3 = "Address : " + tadd.getText();
                tout.setText(data + data1 + data2 + data3);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
                saveFile(tout.getText());
                appendStrToFile("csv.csv", csv);
            } else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        } else if (e.getSource() == readF){
            res.setText("Read File Button Clicked...");
            //the readCSV method returns an aray of strings - each one a comma separated line of data
            strArr = readCSV("customers.csv");
            //now count through each line and create Customer objects from each line
            int index = 0;
            //String result = strArr[index];
            index ++;
            strCustomers = "";
            for(index = 1; index < strArr.size(); index ++){
                //System.out.println(strArr.get(index));
                Customer myCustomer = createCustomer(strArr.get(index));
                //System.out.println(myCustomer);
                //each customer is shown as a form object
                //showCustomer(myCustomer);
                //it would also be possile to add each customer to another ArrayList
                customers.add(myCustomer);
                strCustomers = strCustomers + myCustomer + "\n";
                //index++;
            }
            tout.setText(strCustomers);
            tout.append("Customers Number: " + customers.size());
            //System.out.println(strCustomers);
        } else if (e.getSource() == subTrans){
            String typ = "";
            if(dep.isSelected()){
                typ = "Deposit";
            }else{
                typ = "Withdrawal";
            }
            res.setText("Transaction button pressed: " + typ);
            doTransaction();
        }
    }
    
    public void doTransaction(){
        //the code for a transaction will go here
        BankAccount thisAcct = new BankAccount("", 0);
        boolean hasAcct = false;
        //get transaction type
        String type = "";
        if(dep.isSelected()){
            type = "Deposit";
        }else{
            type = "Withdrawal";
        }
        //get transaction amount
        double amt = 0.0;
        amt = Double.parseDouble(taAmt.getText());
        //get transaction customer
        int ID = Integer.parseInt(taID.getText());
        //determine if they have an account
        for (int i = 0; i < arrAcc.size(); i++){
            BankAccount temp = arrAcc.get(i);
            if(ID == Integer.parseInt(temp.getID())){
                thisAcct = temp;
                hasAcct = true;
                break;
            }
        }
        //if not create one with $100 starting amount, ID for the customer
        if(!hasAcct){
            //create a new account with $100
            thisAcct = new BankAccount("" + ID, 100);
            arrAcc.add(thisAcct);
        }
        //carry out the transaction
        if(type == "Deposit"){
            thisAcct.makeDeposit(amt);
        }else{
            if(thisAcct.makeWithdrawal(amt) < 0){
                res.setText("You cannot reduce your account to zero");
            }
        }
        DecimalFormat dec = new DecimalFormat("#.00 USD");
        String credits = dec.format(amt);

        tout.setText("Account " + ID + ", " + type + ": $" + credits + "\nNew Balance: $" + dec.format(thisAcct.getBalance()));
    }
    
    public String formatDecimal(double number) {
        double epsilon = 0.004f; // 4 tenths of a cent
        if (Math.abs(Math.round(number) - number) < epsilon) {
           return String.format("%10.0f", number); // sdb
        } else {
           return String.format("%10.2f", number); // dj_segfault
        }
    }
    
    public void showCustomer(Customer iC){
        System.out.println(iC);
        JOptionPane.showMessageDialog(c, iC);
    }

    public Customer createCustomer(String inRec){
        Scanner sc = new Scanner(inRec);
        sc.useDelimiter(",");
        String id = sc.next();
        String name = sc.next();
        String mbl = sc.next();
        String DOB = sc.next();
        String add = sc.next();
        Customer nc = new Customer(id, name, mbl, DOB, add);
        return nc;
    }
    
    public void saveFile(String inText) {
        // Creating an instance of file
        Path path
                = Paths.get("gfg.txt");

        // Custom string as an input
        String str
                = inText;

        // Try block to check for exceptions
        try {
            // Now calling Files.writeString() method
            // with path , content & standard charsets
            byte[] arr = str.getBytes();
            Files.write(path, arr);
            //Files.writeString(path, str,
            //        StandardCharsets.UTF_8);

        }

        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.print("Invalid Path");
        }
    }

    public static void appendStrToFile(String fileName, String str)
    {
        // Try block to check for exceptions
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));

            // Writing on output stream
            out.write(str);
            // Closing the connection
            out.close();
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }
    }
    //method for reading CSV file
    public ArrayList readCSV(String inPath){
        String result = "";
        ArrayList line = new ArrayList();
        int index = 0;
        try {
            //parsing a CSV file into Scanner class constructor
            Scanner sc = new Scanner(new File(inPath));
            //read off each line
            sc.useDelimiter("\n"); //sets the delimiter pattern
            //add each line to an array
            while (sc.hasNext()) //returns a boolean value
            {
                result = sc.next() + "\t"; //find and returns the next complete token from this scanner
                line.add(result);
                index ++;
            }
            sc.close(); //closes the scanner
            return line;
            }
            // Catch block to handle the exceptions
            catch (IOException e) {
            // Display message when exception occurs
            System.out.println("exception occurred" + e);
            line.add("");
        }
        return line;
    }
    //Customer Class
    class Customer{
        String cName, cMobile, cDOB, cAddress, cID;

        //full constructor
        public Customer(String inID, String inN, String iMob, String iDOB, String iAdd){
            cID = inID;
            cName = inN;
            cMobile = iMob;
            cDOB = iDOB;
            cAddress = iAdd;
        }
        //default constructor
        public Customer(){
            cName = "";
            cMobile = "";
            cDOB = "";
            cAddress = "";
        }
        public String toString(){
            String result = "";
            result = "ID: " + cID + "-Customer " + cName + ", Born " + cDOB + " lives at " + cAddress + ", and can be contacted at " + cMobile;
            return  result;
        }
    }
}

//Bank Account Class
class BankAccount{
    String acID;
    double dblBalance = 0.0;
    public BankAccount(String inID, double inBal){
        acID = inID;
        dblBalance = inBal;
    }
    public String getID(){
        return acID;
    }
    public double getBalance(){
        return dblBalance;
    }
    public double makeDeposit(double amt){
        dblBalance = dblBalance + amt;
        return dblBalance;
    }
    public double makeWithdrawal(double amt){
        double result = (dblBalance - amt);
        if(result <= 0){
            //res.setText("You do not have enough to withdraw this amount");
            return -1;
        }else{
            //res.setText("Your balance is now " + dblBalance);
            dblBalance = dblBalance - amt;
            return dblBalance;
        }
    }
}
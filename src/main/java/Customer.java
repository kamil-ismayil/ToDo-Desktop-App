import java.util.*;

public class Customer {

    int customerID;
    String name;
    static List<Customer> customers;


    public int getCustomerID() { return customerID; }
    public String getName() { return name; }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomerID(int customerID) { this.customerID = customerID; }
    public void setName(String name) { this.name = name; }

    public String toString(){
        return "ID: " + customerID + " - " + name;
    }

}

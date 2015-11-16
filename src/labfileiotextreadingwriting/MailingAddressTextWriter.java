package labfileiotextreadingwriting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *This is the single use version of LineWriter. This cannot be used within the
 * strategy since it employs a specific type of writer, a mailing address.
 * 
 * @author Alyson
 */
public class MailingAddressTextWriter {
    TextLineWriter tw;
    private boolean append = true;

    public MailingAddressTextWriter() {
    }
    
    private void changeAppend(boolean append){
        this.append = append;
    }
    
    public void newMailingAddress(String fName, String lName, 
            String streetAddress, String city, String stateOrProvince, 
            String zip, DataStrategy data, boolean append){
        changeAppend(append);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(data.getData(), append)));
            out.println(fName + " " + lName);
            out.println(streetAddress);
            out.println(city + ", " + stateOrProvince + " " + zip);
            System.out.println("file writing done: " + data.getData());

        } catch (IOException ex) {
            System.out.println("Problem writing to file: " + ex);
        } finally {
            out.close();
        }
    }
        
}

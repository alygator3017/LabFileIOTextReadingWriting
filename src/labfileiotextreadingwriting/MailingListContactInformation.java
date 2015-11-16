package labfileiotextreadingwriting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Alyson
 */
public class MailingListContactInformation {

    private List<Map<String, String>> list = null;
    private Map map = null;
    private List keysList = null;
    private String firstName = null;
    private String lastName = null;
    private String city = null;
    private String state = null;
    private String zip = null;

    public MailingListContactInformation(List<Map<String, String>> list) {
        this.list = list;
    }

    private void setContact(int num) {
        map = list.get(num - 1);
        Set keys = map.keySet();
        keysList = new ArrayList(keys);
    }

    public Map getContact() {
        return map;
    }

    private void splitName(String fullname){
        String[] tokens = fullname.split(" ");
        if (tokens.length > 0) {
            firstName = tokens[0];
            lastName = tokens[tokens.length - 1];
        }
    }
    public String getFullName(int num){
        setContact(num);
        String fullName = (String) map.get(keysList.get(0));
        return fullName;
    }
    public String getFirstName(int num) {
        setContact(num);
        splitName((String) map.get(keysList.get(0)));
        

        return firstName;
    }

    public String getLastName(int num) {
        setContact(num);
        splitName((String) map.get(keysList.get(0)));
        
        return lastName;
    }

    public String getStreetAddress(int num) {
        setContact(num);
        String address = (String) map.get(keysList.get(1));
        
        return address;
    }

    private void addressSplitter(String address){
        String[] tokens = address.split(" ");
        if (tokens.length > 0) {
            city = tokens[0].substring(0, tokens[0].length()-1);
            state = tokens[tokens.length - 2];
            zip = tokens[tokens.length - 1];
        }
    }
    public String getCity(int num) {
        setContact(num);
        addressSplitter((String) map.get(keysList.get(2)));
        
        return city;
    }

    public String getState(int num) {
        setContact(num);
        addressSplitter((String) map.get(keysList.get(2)));
        
        return state;
    }

    public String getZip(int num) {
        setContact(num);
        addressSplitter((String) map.get(keysList.get(2)));
        
        return zip;

    }
}

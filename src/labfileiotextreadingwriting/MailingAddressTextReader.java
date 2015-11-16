package labfileiotextreadingwriting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alyson
 */
public class MailingAddressTextReader implements ReaderStrategy {

    private BufferedReader in = null;
    private int i = 0;

    public MailingAddressTextReader() {
    }

    @Override
    public List readLines(DataStrategy data) {
        List<Map<String, String>> list = null;
        Map<String, String> map = null;
        try {
            in = new BufferedReader(new FileReader(data.getData()));
            String ln = in.readLine();
            

            list = new ArrayList<>();
            while (ln != null) {
                i++;

                if (i == 1) {
                    map = new LinkedHashMap<>();
                }
                map.put("" + i + "", ln);
                if ((i % 3) == 0) {
                    list.add(map);
                }
                if(i%3 == 0 && i != 1){
                    i = 0;
                }
                ln = in.readLine();

            }
        } catch (IOException o) {
            System.out.println("Problem reading file: " + o);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("problem closing file");;
            }
        }
        return list;

        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.i;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MailingAddressTextReader other = (MailingAddressTextReader) obj;
        if (this.i != other.i) {
            return false;
        }
        return true;
    }
    
}

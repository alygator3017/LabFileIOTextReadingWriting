package labfileiotextreadingwriting;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alyson
 */
public class LabFileIOTextReadingWriting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

//        File data = new File(File.separatorChar
//                + "temp" + File.separatorChar + "Lab1.txt");
//        File data = new File("C:\\temp\\Lab1.txt");
        DataStrategy data = new DataFile(new File(File.separatorChar
                + "temp" + File.separatorChar + "Lab1.txt"));

        BufferedReader in = null;
        MailingAddressTextWriter write = new MailingAddressTextWriter();
        TextLineWriter line = new TextLineWriter();
        //using line writer
        //perks of using line writer- line is a strategy
        line.newLine("Rose Tyler", data, true);
        line.newLine("1234 North Way", data, true);
        line.newLine("Oconomowoc, Wi 53066", data, true);
        //using mailing address
        write.newMailingAddress("Rose", "Tyler", "1234 North Way", "Oconomowoc", "Wi", "53066", data, true);
        write.newMailingAddress("Jack", "Harkness", "1 Face Of Boe Rd", "London", "UK", "19888", data, true);
        
        ReaderStrategy reader = new MailingAddressTextReader();
        List<Map<String, String>> list = reader.readLines(data);
        
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        
        MailingListContactInformation cts = new MailingListContactInformation(list);
        
        System.out.println(cts.getFullName(1) + "s state: " + cts.getState(1));
        
//        Map map = list.get(1);
//        Set keys = map.keySet();
//        List keysList = new ArrayList(keys);
////        for(int i = 0 ; i < keysList.size(); i++){
////            System.out.println(keysList.get(i));
////        }
//        System.out.println(map.get(keysList.get(0)));
    }

}

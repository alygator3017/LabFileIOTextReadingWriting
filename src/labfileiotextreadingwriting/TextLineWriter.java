package labfileiotextreadingwriting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The lineWriterStrategy interface and class setup has the advantage of being
 * more flexible than the MailingAddressTextWriter class. Line writer can be
 * used with any sort of line writing, not designated to one type, like Mailing
 * address. Only downside- you have to write line by line and already have the
 * string pre written as you want it to go into the writer.
 *
 * @author Alyson
 */
public class TextLineWriter implements LineWriterStrategy {

    private boolean append = true;

    private void changeAppend(boolean append) {
        this.append = append;
    }

    @Override
    public void newLine(String line, DataStrategy data, boolean append) {
        changeAppend(append);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(data.getData(), append)));
            out.println(line);
            System.out.println("file writing done: " + data.getData());

        } catch (IOException ex) {
            System.out.println("Problem writing to file: " + ex);
        } finally {
            out.close();
        }
    }
}

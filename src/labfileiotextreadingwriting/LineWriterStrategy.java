package labfileiotextreadingwriting;

/**
 * The lineWriterStrategy interface and class setup has the advantage of being
 * more flexible than the MailingAddressTextWriter class. Line writer can be used
 * with any sort of line writing, not designated to one type, like Mailing address.
 * Only downside- you have to write line by line and already have the string pre written
 * as you want it to go into the writer. 
 * @author Alyson
 */
public interface LineWriterStrategy {

    void newLine(String line, DataStrategy data, boolean append);
    
}

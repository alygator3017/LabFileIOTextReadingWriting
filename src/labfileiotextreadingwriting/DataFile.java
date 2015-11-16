package labfileiotextreadingwriting;

import java.io.File;

/**
 *
 * @author Alyson
 */
public class DataFile implements DataStrategy {

    private final File data;
    
    public DataFile(File data) {
        this.data = data;
    }

    @Override
    public final File getData() {
        return data;
    }
    
    

    
}

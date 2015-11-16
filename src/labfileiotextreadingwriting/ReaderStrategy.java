package labfileiotextreadingwriting;

import java.util.List;

/**
 *
 * @author Alyson
 */
public interface ReaderStrategy {

    List readLines(DataStrategy data);
    
}

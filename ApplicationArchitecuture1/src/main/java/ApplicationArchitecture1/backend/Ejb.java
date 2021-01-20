package ApplicationArchitecture1.backend;

import ApplicationArchitecture1.common.Joiner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Kohei Saito
 */
@Stateless
public class Ejb {
    
    @Inject
    JpaDao dao;
    
    @Inject
    private transient Logger logger;
    
    public List<Joiner> getAllJoiner(){
        
        logger.log(Level.FINE, "Ejb#getAllJoiner() is called.");
        
        List<Joiner> joiner = dao.getAllJoiner();
        
        return joiner;
        
    }
}

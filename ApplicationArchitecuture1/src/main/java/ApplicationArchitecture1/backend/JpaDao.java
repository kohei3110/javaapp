package ApplicationArchitecture1.backend;

import ApplicationArchitecture1.common.Joiner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 
 * @author Kohei Saito
 */
public class JpaDao {
    
    private static final String UNIT_NAME = "oracle_persistence_unit";
    
    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;
    
    @Inject
    private transient Logger logger;
    
    public List<Joiner> getAllJoiner(){
        logger.log(Level.FINE, "JpaDao#getAllJoiner() is called.");
        
        TypedQuery<Joiner> query = em.createNamedQuery(Joiner.SQL_FIND_ALL, Joiner.class);
        
        List<Joiner> joiner = null;
        
        try {
            joiner = query.getResultList();       
        } catch (Throwable t) {
            logger.log(Level.SEVERE, t.getMessage());
        }
        
        return joiner;
    }
}

package ApplicationArchitecture1.frontend;

import ApplicationArchitecture1.common.Joiner;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Kohei Saito
 */
@Named
@ViewScoped
public class BackingBean implements Serializable {
    
    private List<Joiner> joiner;

    @Inject
    private RestClient restClient;    
    
    @Inject
    private transient Logger logger;
    
    @PostConstruct
    public void doInitialize(){
        try{
            joiner = restClient.getAllJoiner();
        } catch (Throwable t){
            logger.log(Level.SEVERE, t.getMessage());
        }
    }
    
    public void doSearch(){
        
        // To Do : Modify code.
        System.out.println("doSearch() is fired!");
        restClient.getAllJoiner();
    }

    public List<Joiner> getJoiner(){
        return joiner;
    }
}

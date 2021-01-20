package ApplicationArchitecture1.backend;

import ApplicationArchitecture1.common.Joiner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Kohei Saito
 */
@RequestScoped
@Path("/joiner")
public class RestServer {
    
    @EJB
    private Ejb ejb;
    
    @Inject
    private transient Logger logger;
    
    @GET
    @Produces("application/json")
    public Response getAllJoiner(){
        
        logger.log(Level.FINE, "RestServer#getAllMember() is called.");
        
        try{
            List<Joiner> member = ejb.getAllJoiner();
            return Response.ok(member).build();
        } catch (Throwable t){
            logger.log(Level.SEVERE, t.getMessage());
            return Response.serverError().build();
        }
    }   
}

package ApplicationArchitecture1.frontend;

import ApplicationArchitecture1.common.Joiner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Kohei Saito
 */
@Dependent
public class RestClient implements Serializable {
    
    private static final String baseName = "applicationArchitecture";
    
    private static final int RESPONSE_CODE_OK = 200;
    
    @Inject
    private transient Logger logger;
    
    /**
     * バックエンドのアプリケーションからMemberデータを全件取得するメソッド。
     * @return Memberデータの結果セット
     */
    public List<Joiner> getAllJoiner(){
        ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        
        String target = bundle.getString("TARGET_URL");
        
        Client client = ClientBuilder.newClient();
        
        WebTarget webTarget = client.target(target);
        
        Invocation.Builder builder = webTarget.request("application/json");
        
        Invocation invocation = builder.buildGet();
        
        Response response = invocation.invoke();
        
        List<Joiner> joiner;
        
        if(response.getStatus() == RESPONSE_CODE_OK){
            joiner = response.readEntity(new GenericType<List<Joiner>>(){});
        } else {
            logger.log(Level.SEVERE, "Server Error");
            joiner = new ArrayList<>(0);
        }
        
        return joiner;
    }
    
}

package ApplicationArchitecture1.frontend;

import ApplicationArchitecture1.common.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RestClient {
    
    private static final String baseName = "applicationArchitecture";
    
    private static final int RESPONSE_CODE_OK = 200;
    
    @Inject
    private Logger logger;
    
    /**
     * バックエンドのアプリケーションからMemberデータを全件取得するメソッド。
     * @return Memberデータの結果セット
     */
    public List<Member> getAllMember(){
        ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        
        String target = bundle.getString("TARGET_URL");
        
        Client client = ClientBuilder.newClient();
        
        WebTarget webTarget = client.target(target);
        
        Invocation.Builder builder = webTarget.request("application/json");
        
        Invocation invocation = builder.buildGet();
        
        Response response = invocation.invoke();
        
        List<Member> member;
        
        if(response.getStatus() == RESPONSE_CODE_OK){
            member = response.readEntity(new GenericType<List<Member>>(){});
        } else {
            logger.log(Level.SEVERE, "Server Error");
            member = new ArrayList<>(0);
        }
        
        return member;
    }
    
}

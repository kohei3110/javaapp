package jwt;

import static jwt.Constants.REMEMBERME_VALIDITY_SECONDS;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author kohei
 */
public class TokenProvider {
    
    private static final Logger logger = Logger.getLogger(TokenProvider.class.getName());
    
    private static final String authenticationKey = "auth";
    
    private String secretKey;
    
    private Long tokenValidity;
    
    private Long tokenValidityForRememberMe;
    
    @PostConstruct
    public void init() {
        this.secretKey = "my-secret-jwt-key";
        this.tokenValidity = TimeUnit.HOURS.toMillis(10);
        this.tokenValidityForRememberMe = TimeUnit.SECONDS.toMillis(REMEMBERME_VALIDITY_SECONDS);
    }
}

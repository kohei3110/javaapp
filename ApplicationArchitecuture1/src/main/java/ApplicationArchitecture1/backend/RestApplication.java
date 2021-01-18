package ApplicationArchitecture1.backend;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * JAX-RSアプリケーションの基底URI、をWebアプリケーションのコンテキストルートからの相対パスとして記載する。
 * @author Kohei Saito
 */
@ApplicationPath("/api")
public class RestApplication extends Application {    
}

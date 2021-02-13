package frontend;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author kohei
 */
public class RestClient implements Serializable{
    private static final long serialVersionUID = 1L;
    
    protected static final int RESPONSE_CODE_OK = 200;
    
    @Inject
    protected Logger logger;
    
    // クエリパラメータをもとに検索結果を取得するメソッド。
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author kohei
 */
@Interceptor
@Dependent
@ElapsedTime
public class ElapsedTimeInterceptor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    Logger logger;
    
    public ElapsedTimeInterceptor(){}        
    
    @AroundInvoke
    public Object invoke(InvocationContext ic) throws Exception{
        
        long start = System.nanoTime();
        Object result = ic.proceed();  // 対象のメソッドを実行
        long end = System.nanoTime();
        
        Class clazz = ic.getMethod().getDeclaringClass();
        Method method = ic.getMethod();
        
        long elapsedTime = end - start;
        
        System.out.println("elapsedTime : " + elapsedTime + "nsecs");
        
        logger.info(clazz.getCanonicalName() + "#" + method.getName() + " was invoked, elapsed : " + elapsedTime + "nsecs");
        
        return result;
    }

}
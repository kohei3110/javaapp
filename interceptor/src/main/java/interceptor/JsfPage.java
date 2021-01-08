/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author kohei
 */
@Named("jsfPage")
@ViewScoped
public class JsfPage {
    
    private String test;
    
    @Interceptors(ElapsedTimeInterceptor.class)
    public void push(){
        System.out.println("push executed!");
        System.out.println(test);
    }

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Named;

/**
 *
 * @author kohei
 */
@Named
@ApplicationScoped
public class PushBean implements Serializable {
    
    @Push(channel = "fromServer")
    private PushContext push;
    
    public void pushAction(){
        String message = "Message from Server";
        System.out.println("PushBean#pushAction() is called.");
        push.send(message);
    }
}

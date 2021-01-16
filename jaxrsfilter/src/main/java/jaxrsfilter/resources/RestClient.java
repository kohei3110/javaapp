/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxrsfilter.resources;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kohei
 */
@Named
@ViewScoped
public class RestClient implements Serializable {
    
    final String TARGET_URL = "http://localhost:8080/jaxrsfilter/test";
    
    public Response getResource(){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET_URL);
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Invocation invocation = builder.buildGet();
        Response response = invocation.invoke();
        return response;
    }
}

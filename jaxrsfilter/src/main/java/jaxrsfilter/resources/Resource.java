/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxrsfilter.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author kohei
 */
@Path("/test")
public class Resource {
    
    @GET
    public Response get(){
        return Response.ok().build();
    }
}

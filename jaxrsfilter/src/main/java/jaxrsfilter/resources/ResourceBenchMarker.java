/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxrsfilter.resources;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author kohei
 */
@Provider
public class ResourceBenchMarker implements ContainerRequestFilter, ContainerResponseFilter {

    @Context
    private HttpServletRequest httpServletRequest;
    
    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        // stdout
        System.out.println("ResourceBenchMarker#filter1");

        // Get currentTimeMillis
        long requestTime = System.currentTimeMillis();

        // Get Session
        HttpSession session = this.httpServletRequest.getSession();

        // Save requestTime into session
        session.setAttribute("requestTime", requestTime);
        
    }

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        // stdout
        System.out.println("ResourceBenchMarker#filter2");

        // Get currentTimeMillis
        long responseTime = System.currentTimeMillis();

        // Get Session
        HttpSession session = this.httpServletRequest.getSession();

        // Get requestTime
        long requestTime = (long) session.getAttribute("requestTime");
        
        // Measure Performance 
        System.out.println("BenchMark : " + (responseTime - requestTime) + "msecs.");
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

/**
 *
 * @author kohei
 */
public class Constants {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String BEARER = "Bearer ";

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final int REMEMBERME_VALIDITY_SECONDS = 24 * 60 * 60; //24 hours
    
}

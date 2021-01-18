/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationArchitecture1.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kohei Saito
 */
public class JpaDao {
    // DBから値を取得する
    
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String USER_NAME = "sample_user";
    private static final String PASSWORD = "WElcome##01";
    private static final String QUERY = "SELECT sysdate FROM dual";
    
    
    
}

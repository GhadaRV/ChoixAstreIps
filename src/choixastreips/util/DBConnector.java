/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choixastreips.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ghada
 */
public class DBConnector {
    
    public static Connection getConnection() throws SQLException{
        Connection connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/astre-ips","root"," ");
        return connection;
        
    }
}

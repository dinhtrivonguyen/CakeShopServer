/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect implements DatabaseInfo{
    
    private static DBConnect instance;
    
    public DBConnect() {
        
    }
    
    public Connection openConnection() throws Exception {
        
        Class.forName(driverName);
     
        Connection con = DriverManager.getConnection(url, user, pass);
        
        return con;
    }
    
    public static DBConnect getInstance() {
        
        if (instance == null) {
            instance = new DBConnect();
        }
        
        return instance;
    }
    
}

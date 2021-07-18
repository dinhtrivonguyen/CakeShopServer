/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dbcontext;

public interface DatabaseInfo {
    
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=CakeShoppingCart";
    public static String user = "sa";
    public static String pass = "abc123";
    
}

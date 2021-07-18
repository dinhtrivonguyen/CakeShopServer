/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LUser;
import model.dbcontext.DBConnect;

public class LoginDAO {
    
    public List<LUser> getAll() {
        
        DBConnect db = DBConnect.getInstance();
        
        List<LUser> lu = new ArrayList<>();
        
        String sql = "select * from tblLUser";
        
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                String email = rs.getString(1);
                String password = rs.getString(2);
                String idUser = rs.getString(3);
                
                LUser tempM = new LUser(email, password);
                lu.add(tempM);
            }
            rs.close();
            stmt.close();
            con.close();
                       
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return lu;
    }
    
    
    public int loginCheckRole(String user, String password) {
        
       DBConnect db = DBConnect.getInstance();
       
       String sql = "select [role]\n" +
            "from tblUser u inner join tblLUser l on u.idUser = l.idUser\n" +
            "Where u.idUser = (\n" +
            "	select idUser from tblLUser where [email] = ? AND [password] = ?\n" +
            ")";
       
       int role = 0;
       
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, user);
            stmt.setString(2, password);            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                role = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
    
    public boolean searchEmail(String email) {
        
       DBConnect db = DBConnect.getInstance();
       
       String sql = "select email from tblLUser where [email] = ?";
       
       String role = "";
       
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, email);     
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                role = rs.getString(1);
            }
            rs.close();
            stmt.close();
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return !"".equals(role);
    }
    
        public void addUserAndRole(String email, String password, String name) {
        
        DBConnect db = DBConnect.getInstance();
        String sql = "insert into tblUser([name], [role]) values(?, ?)\n" +
                      "insert into tblLUser values(?,?,?,(select max(idUser) from tblUser))";
        
        try {
            Connection con = db.openConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,1);
            stmt.setString(3, email);
            stmt.setString(4, name);
            stmt.setString(5, password);
            stmt.execute();
            stmt.close();
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public int getMagazine(String id) {
//        
//       DBConnect db = DBConnect.getInstance();
//       
//       String sql = "select * from Product where [Product ID] = ?";
//       
//       Magazine m = null;
//       
//        try {
//            Connection con = db.openConnection();
//            
//            PreparedStatement stmt = con.prepareStatement(sql);
//            
//            stmt.setString(1, id);
//            
//            ResultSet rs = stmt.executeQuery();
//            
//            while (rs.next()) {
//                
//                String title = rs.getString(2);
//                String publisher = rs.getString(3);
//                double price = rs.getDouble(4);
//                
//                m = new Magazine(id, title, publisher, price);
//            }
//            
//            rs.close();
//            stmt.close();
//            con.close();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return m;
//    }
//    
//    public void addMagazine(Magazine magazine) {
//        
//        DBConnect db = DBConnect.getInstance();
//        
//        String sql = "insert into LUser\n"
//                + "values(?, ?, ?)";
//        
//        try {
//            Connection con = db.openConnection();
//            
//            PreparedStatement stmt = con.prepareStatement(sql);
//            
//            stmt.setString(1, magazine.getMazID());
//            stmt.setString(2, magazine.getMazTitle());
//            stmt.setString(3, magazine.getPublisher());
//            stmt.setDouble(4, magazine.getPrice());
//            
//            stmt.execute();
//            
//            stmt.close();
//            con.close();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
    
//    
//    public void updateMagazine(Magazine magazine) {
//        
//        DBConnect db = DBConnect.getInstance();
//        
//        String sql =  "update Product\n"
//                + "set [Product Name] = ?,\n"
//                + "[Unit] =  ?,\n"
//                + "[Price] = ?\n"
//                + "where [Product ID] = ?";
//        
//        try {
//            Connection con = db.openConnection();
//            
//            PreparedStatement stmt = con.prepareStatement(sql);
//            
//            stmt.setString(1, magazine.getMazTitle());
//            stmt.setString(2, magazine.getPublisher());
//            stmt.setDouble(3, magazine.getPrice());
//            stmt.setString(4, magazine.getMazID());
//            
//            stmt.execute();
//            
//            stmt.close();
//            con.close();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void removeMagazine(String ID) {
//        
//        DBConnect db = DBConnect.getInstance();
//        
//        String sql = "delete from Product where [Product ID] = ?";
//        
//        try {
//            Connection con = db.openConnection();
//            
//            PreparedStatement stmt = con.prepareStatement(sql);
//            
//            stmt.setString(1, ID);
//            
//            stmt.execute();
//            
//            stmt.close();
//            con.close();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}

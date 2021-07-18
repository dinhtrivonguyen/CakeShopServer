/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dbcontext;

import java.util.ArrayList;
import java.util.List;
import model.CheckLogin;
import model.LUser;
import model.dao.LoginDAO;

public class Test {
    
    public static void main(String[] args) {
        CheckLogin cl = new CheckLogin();
        int role = cl.checkRole("ntl@gmail.com", "123");
        System.out.println(role);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.dao.LoginDAO;

/**
 *
 * @author xuanc
 */
public class CheckLogin {
    public int checkRole(String email, String password){
        LoginDAO ldao = new LoginDAO();
        return ldao.loginCheckRole(email, password);
    }
}

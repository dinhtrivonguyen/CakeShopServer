/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author xuanc
 */
public class LUser {
    private String email;
    private String mk;

    public LUser() {
    }

    public LUser(String email, String mk) {
        this.email = email;
        this.mk = mk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public String toString() {
        return "LUser{" + "email=" + email + ", mk=" + mk + '}';
    }
    
}

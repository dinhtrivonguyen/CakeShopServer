/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CheckLogin;


/**
 *
 * @author xuanc
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String user = request.getParameter("email");
        String pass = request.getParameter("password");
        CheckLogin cl = new CheckLogin();
        int role = cl.checkRole(user, pass);
        switch(role){
            case 0:                
            {
                response.setStatus(400);
                break;
            }
            case 1: //1 là role bth
                response.sendRedirect("home-page.jsp");               
                break;
            case 2: // 2 là role admin
                response.sendRedirect("home-page.jsp");
                break;
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

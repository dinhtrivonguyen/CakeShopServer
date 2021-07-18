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
import model.dao.LoginDAO;


/**
 *
 * @author xuanc
 */
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("nusername");
        String pass = request.getParameter("npassword");
        String email = request.getParameter("nemail");
        PrintWriter out = response.getWriter();
        LoginDAO ldao = new LoginDAO();
        boolean exist = ldao.searchEmail(email);
        if (!exist) {
            ldao.addUserAndRole(email, pass, user);
            response.sendRedirect("index.jsp");
        } else {
            response.setStatus(400);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

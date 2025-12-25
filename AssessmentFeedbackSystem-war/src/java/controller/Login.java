/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.UserFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Dhruba
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private UserFacade userFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get form inputs
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Find user by email
        User user = userFacade.findByEmail(email);

        // Validate login
        if (user != null && user.getPassword().equals(password)) {

            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);

            // Get role
            String role = user.getRole();
            
            // Redirect based on role
            if ("ADMIN".equals(role)) {
                response.sendRedirect("admin/dashboard.jsp");
            } else if ("LEADER".equals(role)) {
                response.sendRedirect("leader/dashboard.jsp");
            } else if ("LECTURER".equals(role)) {
                response.sendRedirect("lecturer/dashboard.jsp");
            } else if ("STUDENT".equals(role)) {
                response.sendRedirect("student/dashboard.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}


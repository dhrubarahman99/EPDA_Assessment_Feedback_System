/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.UsersFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Users;

/**
 *
 * @author Dhruba
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/admin/users_create.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Read inputs
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        // validation
        if(name == null || email == null || password == null || role == null ||
           name.trim().isEmpty() || email.trim().isEmpty()|| password.trim().isEmpty()|| role.trim().isEmpty()){
            
           request.setAttribute("error", "All fields are required");
           request.getRequestDispatcher("/admin/users_create.jsp").forward(request, response);
           return;  
        }
        
        // remove spaces
        name = name.trim();
        email = email.trim().toLowerCase();
        role = role.trim();
        
        // check duplicate email
        try {
            Users existing = userFacade.findByEmail(email);
            if (existing != null) {
                request.setAttribute("error", "Email already exists.");
                request.getRequestDispatcher("/admin/users_create.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("error", "Database connection error.");
            request.getRequestDispatcher("/admin/users_create.jsp").forward(request, response);
            return;
        }
        
        // save user object
        try{
            Users u = new Users(name, email, password, role, null);
            userFacade.create(u);
            
            // show success message
            request.setAttribute("success","User registration successful.");
            request.getRequestDispatcher("/admin/users_create.jsp").forward(request,response);
            
        
        } catch(Exception e){
            request.setAttribute("error", "Failed to create user.");
            request.getRequestDispatcher("/admin/users_create.jsp").forward(request, response);
        }
        
        }
        
        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>
    }


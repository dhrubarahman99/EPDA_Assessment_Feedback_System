/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Users;
import facade.UsersFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruba
 */
@WebServlet(name = "lecturer_Profile", urlPatterns = {"/lecturer_Profile"})
public class lecturer_Profile extends HttpServlet {

    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // get user from session
        Users u = (Users) s.getAttribute("currentUser");

        // send to JSP
        request.setAttribute("profileUser", u);
        request.getRequestDispatcher("/lecturer/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // get current session user
        Users u = (Users) s.getAttribute("currentUser");

        // read inputs
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        // validation
        if (name == null || email == null ||
            name.trim().isEmpty() || email.trim().isEmpty()) {

            request.setAttribute("error", "Name and Email are required.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/lecturer/profile.jsp").forward(request, response);
            return;
        }

        // Clean inputs
        name = name.trim();
        email = email.trim().toLowerCase();

        // Check duplicate email
        try {
            Users existing = userFacade.findByEmail(email);

            if (existing != null) {
                // check email exists
                if (!existing.getId().equals(u.getId())) {
                    request.setAttribute("error", "Email already exists.");
                    request.setAttribute("profileUser", u);
                    request.getRequestDispatcher("/lecturer/profile.jsp").forward(request, response);
                    return;
                }
            }

        } catch (Exception e) {
            request.setAttribute("error", "Database connection error.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/lecturer/profile.jsp").forward(request, response);
            return;
        }

        // Update the user object
        u.setName(name);
        u.setEmail(email);

        // update password if not empty
        if (newPassword != null && !newPassword.trim().isEmpty()) {
            newPassword = newPassword.trim();

            u.setPassword(newPassword);
        }

        // Save update
        try {
            userFacade.edit(u);

            // Update session object
            s.setAttribute("currentUser", u);

            request.setAttribute("success", "Profile updated successfully.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/lecturer/profile.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to update profile.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/lecturer/profile.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "lecturer Profile Servlet";
    }
}
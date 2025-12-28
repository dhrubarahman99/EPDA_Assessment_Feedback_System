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
@WebServlet(name = "LeaderProfile", urlPatterns = {"/LeaderProfile"})
public class LeaderProfile extends HttpServlet {

    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) Check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 2) Get user from session
        Users u = (Users) s.getAttribute("currentUser");

        // 3) Send to JSP
        request.setAttribute("profileUser", u);
        request.getRequestDispatcher("/leader/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) Check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 2) Get current session user
        Users u = (Users) s.getAttribute("currentUser");

        // 3) Read inputs
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        // 4) Basic validation
        if (name == null || email == null ||
            name.trim().isEmpty() || email.trim().isEmpty()) {

            request.setAttribute("error", "Name and Email are required.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/leader/profile.jsp").forward(request, response);
            return;
        }

        // 5) Clean inputs
        name = name.trim();
        email = email.trim().toLowerCase();

        // 6) Check duplicate email (allow same user)
        try {
            Users existing = userFacade.findByEmail(email);

            if (existing != null) {
                // if existing belongs to someone else -> duplicate
                if (!existing.getId().equals(u.getId())) {
                    request.setAttribute("error", "Email already exists.");
                    request.setAttribute("profileUser", u);
                    request.getRequestDispatcher("/leader/profile.jsp").forward(request, response);
                    return;
                }
            }

        } catch (Exception e) {
            request.setAttribute("error", "Database connection error.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/leader/profile.jsp").forward(request, response);
            return;
        }

        // 7) Update the user object
        u.setName(name);
        u.setEmail(email);

        // update password if not empty
        if (newPassword != null && !newPassword.trim().isEmpty()) {
            newPassword = newPassword.trim();

            u.setPassword(newPassword);
        }

        // 8) Save update
        try {
            userFacade.edit(u);

            // Update session object
            s.setAttribute("currentUser", u);

            request.setAttribute("success", "Profile updated successfully.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/leader/profile.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to update profile.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/leader/profile.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Leader Profile Servlet";
    }
}
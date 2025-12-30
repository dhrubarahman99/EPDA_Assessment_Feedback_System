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

@WebServlet(name = "StudentProfile", urlPatterns = {"/StudentProfile"})
public class StudentProfile extends HttpServlet {

    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        Users u = (Users) s.getAttribute("currentUser");

        // check role
        if (u.getRole() == null || !u.getRole().equalsIgnoreCase("STUDENT")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        request.setAttribute("profileUser", u);
        request.getRequestDispatcher("/student/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        Users u = (Users) s.getAttribute("currentUser");

        // check role
        if (u.getRole() == null || !u.getRole().equalsIgnoreCase("STUDENT")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        if (name == null || email == null ||
            name.trim().isEmpty() || email.trim().isEmpty()) {

            request.setAttribute("error", "Name and Email are required.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/student/profile.jsp").forward(request, response);
            return;
        }

        name = name.trim();
        email = email.trim().toLowerCase();

        try {
            Users existing = userFacade.findByEmail(email);

            if (existing != null) {
                if (!existing.getId().equals(u.getId())) {
                    request.setAttribute("error", "Email already exists.");
                    request.setAttribute("profileUser", u);
                    request.getRequestDispatcher("/student/profile.jsp").forward(request, response);
                    return;
                }
            }

        } catch (Exception e) {
            request.setAttribute("error", "Database connection error.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/student/profile.jsp").forward(request, response);
            return;
        }

        u.setName(name);
        u.setEmail(email);

        if (newPassword != null && !newPassword.trim().isEmpty()) {
            newPassword = newPassword.trim();
            u.setPassword(newPassword);
        }

        try {
            userFacade.edit(u);

            s.setAttribute("currentUser", u);

            request.setAttribute("success", "Profile updated successfully.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/student/profile.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to update profile.");
            request.setAttribute("profileUser", u);
            request.getRequestDispatcher("/student/profile.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Student Profile Servlet";
    }
}

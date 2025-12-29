package controller;

import entity.Users;
import entity.Mark;
import facade.MarkFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StudentResults", urlPatterns = {"/StudentResults"})
public class StudentResults extends HttpServlet {

    @EJB
    private MarkFacade markFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        Users u = (Users) s.getAttribute("currentUser");

        if (u.getRole() == null || !u.getRole().equalsIgnoreCase("STUDENT")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            List<Mark> marks = markFacade.findByStudentId(u.getId());
            request.setAttribute("marks", marks);
            request.getRequestDispatcher("/student/results.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to load results.");
            request.getRequestDispatcher("/student/results.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Student Results Servlet";
    }
}

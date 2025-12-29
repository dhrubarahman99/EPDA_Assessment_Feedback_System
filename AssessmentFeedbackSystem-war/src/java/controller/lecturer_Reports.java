package controller;

import entity.Module;
import entity.Users;
import facade.EnrollmentFacade;
import facade.ModuleFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "lecturer_Reports", urlPatterns = {"/lecturer_Reports"})
public class lecturer_Reports extends HttpServlet {

    @EJB
    private ModuleFacade moduleFacade;

    @EJB
    private EnrollmentFacade enrollmentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        Users u = (Users) s.getAttribute("currentUser");
        Long lecturer_Id = u.getId();
        // get modules
        List<Module> modules = moduleFacade.findModulesByLecturer(lecturer_Id);
        // build student count list
        List<Long> studentCounts = new ArrayList<>();

        for (Module m : modules) {
            Long count = enrollmentFacade.countStudentsByModule1(m.getId());
            studentCounts.add(count);
        }

        // send to JSP
        request.setAttribute("modules", modules);
        request.setAttribute("studentCounts", studentCounts);

        request.getRequestDispatcher("/lecturer/reports.jsp").forward(request, response);
    }
}

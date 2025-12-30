package controller;

import entity.Module;
import facade.EnrollmentFacade;
import facade.ModuleFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LeaderReportsExportCSV", urlPatterns = {"/LeaderReportsExportCSV"})
public class LeaderReportsExportCSV extends HttpServlet {

    @EJB private ModuleFacade moduleFacade;
    @EJB private EnrollmentFacade enrollmentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // download settings
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=module_summary.csv");

        List<Module> modules = moduleFacade.findAll();

        PrintWriter out = response.getWriter();

        // header
        out.println("Module Code,Module Name,Lecturer,Grade Scheme,No. of Students");

        for (Module m : modules) {

            long count = enrollmentFacade.countStudentsByModule(m.getId());

            String lecturer = "-";
            if (m.getLecturer() != null) {
                lecturer = m.getLecturer().getName();
            }

            String scheme = "-";
            if (m.getGradeScheme() != null) {
                scheme = m.getGradeScheme().getSchemeName();
            }

            out.println(
                clean(m.getModuleCode()) + "," +
                clean(m.getModuleName()) + "," +
                clean(lecturer) + "," +
                clean(scheme) + "," +
                count
            );
        }

        out.flush();
        out.close();
    }

    // CSV cleaning
    private String clean(String text) {
        if (text == null) return "";

        if (text.contains(",") || text.contains("\"") || text.contains("\n")) {
            text = text.replace("\"", "\"\"");
            return "\"" + text + "\"";
        }

        return text;
    }
}

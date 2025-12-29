package controller;

import entity.GradeScheme;
import entity.Module;
import entity.Users;
import facade.GradeSchemeFacade;
import facade.ModuleFacade;
import facade.UsersFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LeaderCreateModule", urlPatterns = {"/LeaderCreateModule"})
public class LeaderCreateModule extends HttpServlet {

    @EJB
    private ModuleFacade moduleFacade;

    @EJB
    private GradeSchemeFacade gradeSchemeFacade;

    @EJB
    private UsersFacade usersFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) Check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 2) Load dropdown data
        List<GradeScheme> schemes = gradeSchemeFacade.findAll();
        List<Users> lecturers = usersFacade.findLecturers();

        request.setAttribute("gradeSchemes", schemes);
        request.setAttribute("lecturers", lecturers);

        request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
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

        // 2) Read inputs
        String moduleCode = request.getParameter("moduleCode");
        String moduleName = request.getParameter("moduleName");
        String gradeSchemeIdStr = request.getParameter("gradeSchemeId");
        String lecturerIdStr = request.getParameter("lecturerId");

        // 3) Reload dropdown data always (so JSP can show dropdowns again even on error)
        List<GradeScheme> schemes = gradeSchemeFacade.findAll();
        List<Users> lecturers = usersFacade.findLecturers();
        request.setAttribute("schemes", schemes);
        request.setAttribute("lecturers", lecturers);

        // 4) Basic validation
        if (moduleCode == null || moduleName == null || gradeSchemeIdStr == null || lecturerIdStr == null
                || moduleCode.trim().isEmpty() || moduleName.trim().isEmpty()
                || gradeSchemeIdStr.trim().isEmpty() || lecturerIdStr.trim().isEmpty()) {

            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
            return;
        }

        moduleCode = moduleCode.trim().toUpperCase();
        moduleName = moduleName.trim();

        Long gradeSchemeId;
        Long lecturerId;

        try {
            gradeSchemeId = Long.parseLong(gradeSchemeIdStr);
            lecturerId = Long.parseLong(lecturerIdStr);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid selection.");
            request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
            return;
        }

        // 5) Check duplicate module code (recommended)
        try {
            Module existing = moduleFacade.findByModuleCode(moduleCode);
            if (existing != null) {
                request.setAttribute("error", "Module code already exists.");
                request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("error", "Database connection error.");
            request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
            return;
        }

        // 6) Find related objects
        GradeScheme scheme = gradeSchemeFacade.find(gradeSchemeId);
        Users lecturer = usersFacade.find(lecturerId);

        if (scheme == null || lecturer == null) {
            request.setAttribute("error", "Selected grade scheme or lecturer not found.");
            request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
            return;
        }

        // 7) Create module
        try {
            Module m = new Module(moduleCode, moduleName, scheme, lecturer);
            moduleFacade.create(m);

            request.setAttribute("success", "Module created successfully.");

            // Clear form values
            request.setAttribute("moduleCodeVal", "");
            request.setAttribute("moduleNameVal", "");

            request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to create module.");
            request.getRequestDispatcher("/leader/module_create.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Leader Module Create Servlet";
    }
}
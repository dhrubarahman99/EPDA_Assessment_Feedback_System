/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Users;
import entity.Module;
import entity.GradeScheme;
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

/**
 *
 * @author Dhruba
 */
@WebServlet(name = "LeaderEditModule", urlPatterns = {"/LeaderEditModule"})
public class LeaderEditModule extends HttpServlet {

    @EJB
    private ModuleFacade moduleFacade;

    @EJB
    private GradeSchemeFacade gradeSchemeFacade;

    @EJB
    private UsersFacade usersFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // read module id
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/LeaderModules");
            return;
        }

        Long id;
        try {
            id = Long.parseLong(idStr);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/LeaderModules");
            return;
        }

        // find module
        Module m = moduleFacade.find(id);
        if (m == null) {
            response.sendRedirect(request.getContextPath() + "/LeaderModules");
            return;
        }

        // load dropdown data
        List<GradeScheme> schemes = gradeSchemeFacade.findAll();
        List<Users> lecturers = usersFacade.findLecturers();

        // send JSP
        request.setAttribute("module", m);
        request.setAttribute("schemes", schemes);
        request.setAttribute("lecturers", lecturers);
        request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // read inputs
        String idStr = request.getParameter("id");
        String moduleName = request.getParameter("moduleName");
        String gradeSchemeIdStr = request.getParameter("gradeSchemeId");
        String lecturerIdStr = request.getParameter("lecturerId");

        // reload dropdown
        List<GradeScheme> schemes = gradeSchemeFacade.findAll();
        List<Users> lecturers = usersFacade.findLecturers();
        request.setAttribute("schemes", schemes);
        request.setAttribute("lecturers", lecturers);

        // validation
        if (idStr == null || moduleName == null || gradeSchemeIdStr == null || lecturerIdStr == null
                || idStr.trim().isEmpty() || moduleName.trim().isEmpty()
                || gradeSchemeIdStr.trim().isEmpty() || lecturerIdStr.trim().isEmpty()) {

            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);
            return;
        }

        Long id;
        Long gradeSchemeId;
        Long lecturerId;

        try {
            id = Long.parseLong(idStr);
            gradeSchemeId = Long.parseLong(gradeSchemeIdStr);
            lecturerId = Long.parseLong(lecturerIdStr);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid selection.");
            request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);
            return;
        }

        // find module
        Module m = moduleFacade.find(id);
        if (m == null) {
            request.setAttribute("error", "Module not found.");
            request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);
            return;
        }

        // find objects
        GradeScheme scheme = gradeSchemeFacade.find(gradeSchemeId);
        Users lecturer = usersFacade.find(lecturerId);

        if (scheme == null || lecturer == null) {
            request.setAttribute("error", "Grade scheme or lecturer not found.");
            request.setAttribute("module", m);
            request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);
            return;
        }

        // update module object
        m.setModuleName(moduleName.trim());
        m.setGradeScheme(scheme);
        m.setLecturer(lecturer);

        // save to db
        try {
            moduleFacade.edit(m);

            request.setAttribute("success", "Module updated successfully.");
            request.setAttribute("module", m);
            request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to update module.");
            request.setAttribute("module", m);
            request.getRequestDispatcher("/leader/module_edit.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Leader Edit Module Servlet";
    }
}

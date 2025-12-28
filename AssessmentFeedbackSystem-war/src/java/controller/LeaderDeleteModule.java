package controller;

import entity.Module;
import facade.ModuleFacade;
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
@WebServlet(name = "LeaderDeleteModule", urlPatterns = {"/LeaderDeleteModule"})
public class LeaderDeleteModule extends HttpServlet {

    @EJB
    private ModuleFacade moduleFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) Check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 2) Read module ID
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

        // 3) Find module
        Module m = moduleFacade.find(id);

        if (m == null) {
            response.sendRedirect(request.getContextPath() + "/LeaderModules");
            return;
        }

        // 4) Delete module
        try {
            moduleFacade.remove(m);
        } catch (Exception e) {
            // silently fail and redirect (simple + safe)
        }

        // 5) Redirect back to modules list
        response.sendRedirect(request.getContextPath() + "/LeaderModules");
    }

    @Override
    public String getServletInfo() {
        return "Leader Delete Module Servlet";
    }
}


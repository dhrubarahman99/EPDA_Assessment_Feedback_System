package controller;

import entity.Module;
import facade.ModuleFacade;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LeaderModules", urlPatterns = {"/LeaderModules"})
public class LeaderModules extends HttpServlet {

    @EJB
    private ModuleFacade moduleFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) Check login session
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("currentUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 2) Read inputs
        String q = request.getParameter("q");        // search text
        String sort = request.getParameter("sort"); // asc / desc

        if (sort == null || sort.isEmpty()) {
            sort = "asc"; // default
        }

        try {
            List<Module> modules;

            // 3) Search logic
            if (q == null || q.trim().isEmpty()) {
                modules = moduleFacade.findAll();
            } else {
                modules = moduleFacade.findByModuleName(q.trim());
            }

            // 4) Sorting logic
            if (sort.equals("asc")) {
                Collections.sort(modules, new Comparator<Module>() {
                    @Override
                    public int compare(Module a, Module b) {
                        return a.getModuleName().compareToIgnoreCase(b.getModuleName());
                    }
                });
            }

            if (sort.equals("desc")) {
                Collections.sort(modules, new Comparator<Module>() {
                    @Override
                    public int compare(Module a, Module b) {
                        return b.getModuleName().compareToIgnoreCase(a.getModuleName());
                    }
                });
            }

            // 5) Send to JSP
            request.setAttribute("modules", modules);
            request.setAttribute("q", q);
            request.setAttribute("sort", sort);

            request.getRequestDispatcher("/leader/modules.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Failed to load modules.");
            request.getRequestDispatcher("/leader/modules.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Leader Modules Servlet";
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import facade.ModuleFacade;
import entity.Module;
import facade.ClassGroupFacade;
import entity.ClassGroup;

/**
 *
 * @author Dhruba
 */
@WebServlet(name = "admin_CreateClasses", urlPatterns = {"/admin_CreateClasses"})
public class admin_CreateClasses extends HttpServlet {
    
    @EJB
    private ModuleFacade moduleFacade;
    @EJB
    private ClassGroupFacade classgroupFacade;
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        Long module = Long.parseLong(request.getParameter("Module"));
        Module module1 = moduleFacade.findByID(module);
        name = name.trim();
        
        ClassGroup class1 = new ClassGroup(name, module1);
        
        classgroupFacade.create(class1);
        request.setAttribute("success","Creation Successful");
        request.getRequestDispatcher("/admin_get_class_user_module_list?function=classes_create").include(request,response);
    }
}


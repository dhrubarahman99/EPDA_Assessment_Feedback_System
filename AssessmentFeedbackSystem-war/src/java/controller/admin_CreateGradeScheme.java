/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import facade.GradeSchemeFacade;
import entity.GradeScheme;
/**
 *
 * @author Dhruba
 */
@WebServlet(name = "admin_CreateGradeScheme", urlPatterns = {"/admin_CreateGradeScheme"})
public class admin_CreateGradeScheme extends HttpServlet {
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB 
    private GradeSchemeFacade gradeschemeFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        int aMin = Integer.parseInt(request.getParameter("aMin"));
        int bMin = Integer.parseInt(request.getParameter("bMin"));
        int cMin = Integer.parseInt(request.getParameter("cMin"));
        int dMin = Integer.parseInt(request.getParameter("dMin"));
        
        
        
        name = name.trim();
        
        if(name == null){
            request.setAttribute("success","Please fill in all fields");
            request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_create").include(request,response);
        }
        
        else if(aMin <= bMin || bMin<= cMin || cMin <= dMin){
            request.setAttribute("success","Please key in valid values");
            request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_create").include(request,response);
        }
        else{
            GradeScheme gs = new GradeScheme(name, aMin, bMin, cMin, dMin);
            gradeschemeFacade.create(gs);
            request.setAttribute("success","Creation Successful");
            request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_create").include(request,response);
        }
        
    }
}


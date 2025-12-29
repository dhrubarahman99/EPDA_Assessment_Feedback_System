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
import entity.Assessment;
import facade.AssessmentFacade;
/**
 *
 * @author Dhruba
 */
@WebServlet(name = "lecturer_CreateAssessment", urlPatterns = {"/lecturer_CreateAssessment"})
public class lecturer_CreateAssessment extends HttpServlet {
    
    @EJB
    private ModuleFacade moduleFacade;
    @EJB
    private AssessmentFacade assessmentFacade;
    
    

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
        
        String title = request.getParameter("title");
        int weightage = Integer.parseInt(request.getParameter("weightage"));
        Long module = Long.parseLong(request.getParameter("moduleIds"));
        Module module1 = moduleFacade.findByID(module);
        title = title.trim();
        
        if(title == null){
            request.setAttribute("success","Please fill in all fields");
            request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=assessments_create").include(request,response);
        }else{
            Assessment assessment = new Assessment(title, weightage, module1);
        
            assessmentFacade.create(assessment);
            request.setAttribute("success","Creation Successful");
            request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=assessments_create").include(request,response);
        }
        
        
    }
}


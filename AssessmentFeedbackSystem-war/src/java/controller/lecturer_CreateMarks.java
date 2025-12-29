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
import entity.Enrollment;
import entity.Assessment;
import facade.AssessmentFacade;
import facade.EnrollmentFacade;
import facade.MarkFacade;
import entity.Mark;
/**
 *
 * @author Dhruba
 */
@WebServlet(name = "lecturer_CreateMarks", urlPatterns = {"/lecturer_CreateMarks"})
public class lecturer_CreateMarks extends HttpServlet {
    
    @EJB
    private EnrollmentFacade enrollmentFacade;
    @EJB
    private AssessmentFacade assessmentFacade;
    @EJB
    private MarkFacade markFacade;

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
        
        int score = Integer.parseInt(request.getParameter("score"));
        String feedback = request.getParameter("feedback");
        Long enrollementIds = Long.parseLong(request.getParameter("enrollementIds"));
        Long assessmentIds = Long.parseLong(request.getParameter("assessmentIds"));
        
        Enrollment enrollment = enrollmentFacade.findByID(enrollementIds);
        Assessment assessment = assessmentFacade.findByID(assessmentIds);
        
        
        feedback = feedback.trim();
        
        if(feedback == null){
            request.setAttribute("success","Please fill in all fields");
            request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=marks_create").include(request,response);
        }else{
            Mark mark = new Mark(score, feedback, enrollment, assessment);
        
            markFacade.create(mark);
            request.setAttribute("success","Creation Successful");
            request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=marks_create").include(request,response);
        }
        
        
    }
}


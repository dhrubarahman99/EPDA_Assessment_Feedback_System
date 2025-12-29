package controller;


import facade.AssessmentFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecturer_DeleteAssessment")
public class lecturer_DeleteAssessment extends HttpServlet {
    
    @EJB
    private AssessmentFacade assessmentFacade;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long assessmentIds = Long.parseLong(request.getParameter("assessmentIds"));
       
       assessmentFacade.deleteAssessment(assessmentIds);
       
       request.setAttribute("success","Deletion Successful");
       request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=assessments_delete").include(request,response);
       
    }
    }

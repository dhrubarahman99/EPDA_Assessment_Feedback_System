package controller;


import entity.Users;
import facade.AssessmentFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Assessment;

@WebServlet("/lecturer_SearchAsssessment")
public class lecturer_SearchAsssessment extends HttpServlet {
    
    @EJB
    private AssessmentFacade assessmentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long assessmentIds = Long.parseLong(request.getParameter("assessmentIds"));
       
       
       Assessment assessment = assessmentFacade.findByID(assessmentIds);
       
       Long id = assessment.getId();
       String title = assessment.getTitle();
       int weightage = assessment.getWeightage();
       Long moduleId = assessment.getModule().getId();
       
       request.setAttribute("id", id);
       request.setAttribute("title", title);
       request.setAttribute("weightage", weightage);
       request.setAttribute("moduleId", moduleId);
       
       request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=assessments_search").include(request,response);
       
    }
    }

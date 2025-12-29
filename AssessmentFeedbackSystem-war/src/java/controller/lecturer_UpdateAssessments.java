package controller;


import facade.AssessmentFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecturer_UpdateAssessments")
public class lecturer_UpdateAssessments extends HttpServlet {
    
    @EJB
    private AssessmentFacade assessmentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long assessmentIds = Long.parseLong(request.getParameter("assessmentIds"));
       String title = request.getParameter("title");
       int weightage = Integer.parseInt(request.getParameter("weightage"));
       Long moduleIds = Long.parseLong(request.getParameter("moduleIds"));
     
       title = title.trim();
       if(title == null){
           request.setAttribute("success","Please Enter all fields");
           request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=assessments_update").include(request,response);
       }
       else{
           assessmentFacade.updateAssessment(assessmentIds, title, weightage, moduleIds);
           request.setAttribute("success","Update Successful");
           request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=assessments_update").include(request,response);
       }
       
       
    }
    }

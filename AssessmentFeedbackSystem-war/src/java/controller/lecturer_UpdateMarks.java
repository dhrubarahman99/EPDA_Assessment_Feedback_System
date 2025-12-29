package controller;



import facade.MarkFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecturer_UpdateMarks")
public class lecturer_UpdateMarks extends HttpServlet {
    
    @EJB
    private MarkFacade markFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long marksIds = Long.parseLong(request.getParameter("marksIds"));
       int score = Integer.parseInt(request.getParameter("score"));
       String feedback = request.getParameter("feedback");
       Long enrollementIds = Long.parseLong(request.getParameter("enrollementIds"));
       Long assessmentIds = Long.parseLong(request.getParameter("assessmentIds"));
     
       feedback = feedback.trim();
       if(feedback == null){
           request.setAttribute("success","Please Enter all fields");
           request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=marks_update").include(request,response);
       }
       else{
           markFacade.updateMark(marksIds, score, feedback, enrollementIds, assessmentIds);
           request.setAttribute("success","Update Successful");
           request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=marks_update").include(request,response);
       }
       
       
    }
    }

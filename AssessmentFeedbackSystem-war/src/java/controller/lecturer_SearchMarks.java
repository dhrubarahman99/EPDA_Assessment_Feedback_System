package controller;



import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Mark;
import facade.MarkFacade;

@WebServlet("/lecturer_SearchMarks")
public class lecturer_SearchMarks extends HttpServlet {
    
    @EJB
    private MarkFacade markFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long marksIds = Long.parseLong(request.getParameter("marksIds"));
       
       
       Mark mark = markFacade.findByID(marksIds);
       
       Long id = mark.getId();
       int score = mark.getScore();
       String feedback = mark.getFeedback();
       Long enrollmentId = mark.getEnrollment().getId();
       Long assessmentId = mark.getAssessment().getId();
       
       request.setAttribute("id", id);
       request.setAttribute("score", score);
       request.setAttribute("feedback", feedback);
       request.setAttribute("enrollmentId", enrollmentId);
       request.setAttribute("assessmentId", assessmentId);
       
       request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=marks_search").include(request,response);
       
    }
    }

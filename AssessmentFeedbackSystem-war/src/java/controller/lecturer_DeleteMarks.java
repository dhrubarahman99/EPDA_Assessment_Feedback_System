package controller;


import facade.AssessmentFacade;
import facade.MarkFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecturer_DeleteMarks")
public class lecturer_DeleteMarks extends HttpServlet {
    
    @EJB
    private MarkFacade markFacade;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long marksIds = Long.parseLong(request.getParameter("marksIds"));
       
       markFacade.deleteMark(marksIds);
       
       request.setAttribute("success","Deletion Successful");
       request.getRequestDispatcher("/lecturer_get_assessment_module_enrollment_marks_list?function=marks_delete").include(request,response);
       
    }
    }

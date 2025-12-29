package controller;


import facade.AssessmentFacade;
import facade.EnrollmentFacade;
import facade.MarkFacade;
import facade.ModuleFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecturer_get_assessment_module_enrollment_marks_list")
public class lecturer_get_assessment_module_enrollment_marks_list extends HttpServlet {
    
    @EJB
    private AssessmentFacade assessmentFacade;
    
    @EJB
    private ModuleFacade moduleFacade;
    
    @EJB
    private EnrollmentFacade enrollmentFacade;
    
    @EJB
    private MarkFacade markFacade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<Long> assessmentIds = assessmentFacade.getIDs();
        
        
        List<Long> moduleIds = moduleFacade.getmoduleIDs();

        
        List<Long>enrollmentIds = enrollmentFacade.getIDs();

        
        List<Long>marksIds = markFacade.getIDs();

        
        
        
        String function = request.getParameter("function");
        
        
        request.setAttribute("assessmentIds", assessmentIds);
        request.setAttribute("moduleIds", moduleIds);
        request.setAttribute("enrollmentIds", enrollmentIds);
        request.setAttribute("marksIds", marksIds);
        request.getRequestDispatcher("/lecturer/"+function+".jsp").forward(request, response);
    }
}

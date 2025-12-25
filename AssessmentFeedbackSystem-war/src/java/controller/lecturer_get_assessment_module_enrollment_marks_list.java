package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecturer_get_assessment_module_enrollment_marks_list")
public class lecturer_get_assessment_module_enrollment_marks_list extends HttpServlet {
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<String> assessmentIds = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            assessmentIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        
        List<String> moduleIds = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            moduleIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        List<String>enrollmentIds = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            enrollmentIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        List<String>marksIds = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            marksIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        
        String function = request.getParameter("function");
        
        
        request.setAttribute("assessmentIds", assessmentIds);
        request.setAttribute("moduleIds", moduleIds);
        request.setAttribute("enrollmentIds", enrollmentIds);
        request.setAttribute("marksIds", marksIds);
        request.getRequestDispatcher("/lecturer/"+function+".jsp").forward(request, response);
    }
}

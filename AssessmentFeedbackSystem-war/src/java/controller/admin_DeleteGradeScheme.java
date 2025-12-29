package controller;


import facade.GradeSchemeFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_DeleteGradeScheme")
public class admin_DeleteGradeScheme extends HttpServlet {
    
    @EJB 
    private GradeSchemeFacade gradeschemeFacade;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long gradeschemeId = Long.parseLong(request.getParameter("gradeschemeId"));
       
       gradeschemeFacade.deleteGradeScheme(gradeschemeId);
       
       request.setAttribute("success","Deletion Successful");
       request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_delete").include(request,response);
       
    }
    }

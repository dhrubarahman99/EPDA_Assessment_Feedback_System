package controller;


import facade.GradeSchemeFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_UpdateGradeScheme")
public class admin_UpdateGradeScheme extends HttpServlet {
    
    @EJB
    private GradeSchemeFacade gradeschemeFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long gradeschemeId = Long.parseLong(request.getParameter("gradeschemeId"));
       String name = request.getParameter("name");
       int aMin = Integer.parseInt(request.getParameter("aMin"));
       int bMin = Integer.parseInt(request.getParameter("bMin"));
       int cMin = Integer.parseInt(request.getParameter("cMin"));
       int dMin = Integer.parseInt(request.getParameter("dMin"));
       
       name = name.trim();
       
       if(name == null){
           request.setAttribute("success","Please Enter all fields");
           request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_update").include(request,response);
       }
       
       else if(aMin <= bMin || bMin<= cMin || cMin <= dMin){
            request.setAttribute("success","Please key in valid values");
            request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_update").include(request,response);
       }
       else{
           gradeschemeFacade.updateGradeScheme(gradeschemeId, name, aMin, bMin, cMin, dMin);
           request.setAttribute("success","Update Successful");
           request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_update").include(request,response);
       } 
       
       
       
    }
    }

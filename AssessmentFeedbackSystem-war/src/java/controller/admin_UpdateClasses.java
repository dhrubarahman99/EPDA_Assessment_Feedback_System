package controller;


import facade.ClassGroupFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_UpdateClasses")
public class admin_UpdateClasses extends HttpServlet {
    
    @EJB
    private ClassGroupFacade classgroupFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long classId = Long.parseLong(request.getParameter("classId"));
       String name = request.getParameter("name");
       Long moduleId = Long.parseLong(request.getParameter("moduleId"));
     
       name = name.trim();
       
       
       
       classgroupFacade.updateClassgroup(classId, name, moduleId);
       request.setAttribute("success","Update Successful");
       request.getRequestDispatcher("/admin_get_class_user_module_list?function=classes_update").include(request,response);
       
    }
    }

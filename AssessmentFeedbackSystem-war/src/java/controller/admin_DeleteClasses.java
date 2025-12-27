package controller;


import facade.ClassGroupFacade;
import facade.UsersFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_DeleteClasses")
public class admin_DeleteClasses extends HttpServlet {
    
    @EJB
    private ClassGroupFacade classgroupFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long classId = Long.parseLong(request.getParameter("classId"));
       
       classgroupFacade.deleteClassgroup(classId);
       
       request.setAttribute("success","Deletion Successful");
       request.getRequestDispatcher("/admin_get_class_user_module_list?function=classes_delete").include(request,response);
       
    }
    }

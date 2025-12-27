package controller;


import facade.UsersFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_DeleteUser")
public class admin_DeleteUser extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long userId = Long.parseLong(request.getParameter("userId"));
       
       
       userFacade.deleteUser(userId);
       request.setAttribute("success","Deletion Successful");
       request.getRequestDispatcher("/admin_get_class_user_module_list?function=users_delete").include(request,response);
       
    }
    }

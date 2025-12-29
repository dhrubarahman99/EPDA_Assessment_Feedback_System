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

@WebServlet("/admin_UpdateUser")
public class admin_UpdateUser extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long userId = Long.parseLong(request.getParameter("userId"));
       String email = request.getParameter("email");
       String name = request.getParameter("name");
       String password = request.getParameter("password");
       String role = request.getParameter("role");
       
       email = email.trim();
       name = name.trim();
       
       if(name == null || email == null || password == null || role ==null){
           request.setAttribute("success","Please Enter all fields");
           request.getRequestDispatcher("/admin_get_class_user_module_list?function=users_update").include(request,response);
       }
       else{
           userFacade.updateUser(userId, email, name, password, role);
           request.setAttribute("success","Update Successful");
           request.getRequestDispatcher("/admin_get_class_user_module_list?function=users_update").include(request,response);
       }
       
       
       
    }
    }

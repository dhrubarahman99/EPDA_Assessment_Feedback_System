package controller;


import entity.Users;
import facade.UsersFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_SearchUser")
public class admin_SearchUser extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long userId = Long.parseLong(request.getParameter("userId"));
       
       
       Users user = userFacade.findByID(userId);
       
       Long id = user.getId();
       String name = user.getName();
       String email = user.getEmail();
       String password = user.getPassword();
       String role = user.getRole();
       
       Users leaderw = user.getLeader();
       
       Long leader = null;
       if(leaderw != null){
           leader = leaderw.getId();
       }
       
       request.setAttribute("id", id);
       request.setAttribute("name", name);
       request.setAttribute("email", email);
       request.setAttribute("password", password);
       request.setAttribute("role", role);
       request.setAttribute("leader", leader);
       
       
       
       request.getRequestDispatcher("/admin_get_class_user_module_list?function=users_search").include(request,response);
       
    }
    }

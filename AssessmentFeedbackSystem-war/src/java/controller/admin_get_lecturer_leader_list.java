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

@WebServlet("/admin/admin_get_lecturer_leader_list")
public class admin_get_lecturer_leader_list extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       List<Long> lecturerIds = userFacade.findUserIdsByRole("LECTURER");
       List<Long> leaderIds = userFacade.findUserIdsByRole("LEADER");


        
        
        request.setAttribute("lecturerIds", lecturerIds);
        request.setAttribute("leaderIds", leaderIds);
        request.getRequestDispatcher("lecturer_assign_leader.jsp").forward(request, response);
    }
    }

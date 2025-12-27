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

@WebServlet("/admin/admin_LecturerAssignLeader")
public class admin_LecturerAssignLeader extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long Leader = Long.parseLong(request.getParameter("Leader"));
       Long Lecturer = Long.parseLong(request.getParameter("Lecturer"));
       
       userFacade.setLeaderID(Leader, Lecturer);
       request.setAttribute("success","Assignment Successful");
       request.getRequestDispatcher("lecturer_assign_leader.jsp").include(request,response);
       
    }
    }

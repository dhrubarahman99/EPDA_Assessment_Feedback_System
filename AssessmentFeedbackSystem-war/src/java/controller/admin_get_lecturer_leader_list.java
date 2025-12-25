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

@WebServlet("/admin/admin_get_lecturer_leader_list")
public class admin_get_lecturer_leader_list extends HttpServlet {
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<String> lecturerIds = new ArrayList<>();
        Random random = new Random();

       

        for (int i = 0; i < 10; i++) {
            lecturerIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        
        List<String> leaderIds = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            leaderIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        
        request.setAttribute("lecturerIds", lecturerIds);
        request.setAttribute("leaderIds", leaderIds);
        request.getRequestDispatcher("lecturer_assign_leader.jsp").forward(request, response);
    }
}

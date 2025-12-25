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

@WebServlet("/admin_get_gradescheme_list")
public class admin_get_gradescheme_list extends HttpServlet {
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<String> gradeschemeIds = new ArrayList<>();
        Random random = new Random();

       

        for (int i = 0; i < 10; i++) {
            gradeschemeIds.add(String.valueOf(random.nextInt(1000)));
        }
        String function = request.getParameter("function");
        
        
        request.setAttribute("gradeschemeIds", gradeschemeIds);
        request.getRequestDispatcher("/admin/"+function+".jsp").forward(request, response);
    }
}

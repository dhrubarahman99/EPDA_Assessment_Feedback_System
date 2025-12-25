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

@WebServlet("/get_module_list")
public class get_module_list extends HttpServlet {
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<String> moduleIds = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            moduleIds.add(String.valueOf(random.nextInt(1000)));
        }
        
        
        request.setAttribute("moduleIds", moduleIds);
        request.getRequestDispatcher("/admin/classes_create.jsp")
               .forward(request, response);
    }
}

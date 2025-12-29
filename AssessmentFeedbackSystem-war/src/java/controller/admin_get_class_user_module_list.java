package controller;


import facade.ClassGroupFacade;
import facade.ModuleFacade;
import facade.UsersFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_get_class_user_module_list")
public class admin_get_class_user_module_list extends HttpServlet {
    
    @EJB
    private UsersFacade userFacade;
    @EJB 
    private ClassGroupFacade classgroupFacade;
    @EJB 
    private ModuleFacade moduleFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       List<Long> userIds = userFacade.getuserIDs();
       List<Long> studentIds = userFacade.getstudentIDs();
       List<Long> classgroupIds = classgroupFacade.getclassgroupIDs();
       List<Long> moduleIds = moduleFacade.getmoduleIDs();
       
       String function = request.getParameter("function");

        
        
        request.setAttribute("userIds", userIds);
        request.setAttribute("classgroupIds", classgroupIds);
        request.setAttribute("moduleIds", moduleIds);
        request.setAttribute("studentIds", studentIds);
        request.getRequestDispatcher("/admin/"+function+".jsp").forward(request, response);
    }
    }

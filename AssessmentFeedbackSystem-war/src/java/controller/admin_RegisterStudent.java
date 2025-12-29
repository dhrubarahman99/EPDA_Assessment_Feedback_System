package controller;

import entity.Enrollment;
import entity.ClassGroup;
import entity.Users;
import facade.ClassGroupFacade;
import facade.EnrollmentFacade;
import facade.UsersFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_RegisterStudent")
public class admin_RegisterStudent extends HttpServlet {
    
    @EJB
    private EnrollmentFacade enrollmentFacade;
    
    @EJB
    private UsersFacade usersFacade;
    
    @EJB
    private ClassGroupFacade classgroupFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long classId = Long.parseLong(request.getParameter("classId"));
       Long userId = Long.parseLong(request.getParameter("userId"));
       
       Users user = usersFacade.findByID(userId);
       ClassGroup class1 = classgroupFacade.findByID(classId);
       
       Enrollment enrollment = new Enrollment(user, class1);
       
       enrollmentFacade.create(enrollment);
       
       request.setAttribute("success","Registration Successful");
       request.getRequestDispatcher("/admin_get_class_user_module_list?function=classes_register_students").include(request,response);
       
    }
    }

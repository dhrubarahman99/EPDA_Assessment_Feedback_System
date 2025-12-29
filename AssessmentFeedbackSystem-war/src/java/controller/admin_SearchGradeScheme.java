package controller;


import entity.GradeScheme;
import facade.GradeSchemeFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin_SearchGradeScheme")
public class admin_SearchGradeScheme extends HttpServlet {
    
    @EJB
    private GradeSchemeFacade gradeschemeFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       Long gradeschemeId = Long.parseLong(request.getParameter("gradeschemeId"));
       
       
       GradeScheme gs = gradeschemeFacade.findByID(gradeschemeId);
       
       Long id = gs.getId();
       String name = gs.getSchemeName();
       int aMin = gs.getAMin();
       int bMin = gs.getBMin();
       int cMin = gs.getCMin();
       int dMin = gs.getDMin();
       
       request.setAttribute("id", id);
       request.setAttribute("name", name);
       request.setAttribute("aMin", aMin);
       request.setAttribute("bMin", bMin);
       request.setAttribute("cMin", cMin);
       request.setAttribute("dMin", dMin);
       
       request.getRequestDispatcher("/admin_get_gradescheme_list?function=gradescheme_search").include(request,response);
       
    }
    }

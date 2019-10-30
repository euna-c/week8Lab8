
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 784564
 */
public class NoteServlet extends HttpServlet {

    

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/note.jsp")
                    .forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        //if action is null do "", or do action
        action = action == null ? "" : action;
        switch (action) 
        {
            case "add":
                request.setAttribute("msg", "hihi");
                break;
        
            case "Delete Note":
        request.setAttribute("msg", "delete");
        break;
        }
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/note.jsp")
                    .forward(request, response);
    }

  
}

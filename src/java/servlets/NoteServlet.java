
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;

/**
 *
 * @author 784564
 */
public class NoteServlet extends HttpServlet {

    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            NoteService ns = new NoteService();
            List<Note> notes = ns.getAll();
            request.setAttribute("notes", notes);
            
            
            getServletContext().getRequestDispatcher("/WEB-INF/note.jsp")
                    .forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            NoteService ns = new NoteService();
            
            String titleTxt = request.getParameter("title");
            String contentsTxt = request.getParameter("content");
            
            String action = request.getParameter("action");
            //if action is null do "", or do action
            action = action == null ? "" : action;
            switch (action) 
            {
                case "add":
                {
                    ns.insert(titleTxt, contentsTxt);
                }
                break;
                
                
            }
            
            
            //if you click any button, it displays the contents in the table
            List<Note> notes = ns.getAll();
            request.setAttribute("notes", notes);
            
            getServletContext().getRequestDispatcher("/WEB-INF/note.jsp")
                    .forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}

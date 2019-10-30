package dataaccess;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Note;

/**
 *
 * @author 784564
 */
public class NoteDB {
    
    public static Note getNoteByNoteId(int noteid) 
    {
        EntityManager em =
			DBUtil.getEmFactory().createEntityManager();
        try 
        {
            Note note = em.find(Note.class, noteid);
            return note;
        } 
        finally 
        {
            em.close();
        }
    }
    
    public void insert(Note note)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
     
        try
        {
            em.persist(note);
            trans.commit();
        }
        catch (Exception e)
        {
            System.out.println(e);
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public void update(Note note) throws Exception 
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(note);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public List<Note> getAll() throws Exception 
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Note> notes = em.createNamedQuery("Note.findAll", Note.class).getResultList();
            return notes;
        } finally {
            em.close();
        }
    }
    public Note get(int noteid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
         try {
             Note note = em.find(Note.class, noteid);
             return note;
         } finally {
             em.close();
         }
    }
    
public void delete(Note note) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try 
        {
            trans.begin();
            em.remove(em.merge(note));
            trans.commit();
        } 
        catch (Exception e) 
        {
            trans.rollback();
        } 
        finally 
        {
            em.close();
        }
    }
}


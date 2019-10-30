/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.NoteDB;
import java.util.Date;
import java.util.List;
import models.Note;

/**
 *
 * @author 784564
 */
public class NoteService 
{
    
    public Note get(int noteid) throws Exception 
    {
        NoteDB db = new NoteDB();
        Note note = db.get(noteid);
        return note;
    }
    
   public List<Note> getAll() throws Exception 
   {
        NoteDB db = new NoteDB();
        List<Note> notes = db.getAll();
        return notes;
    }
   public void update(int noteid, String title, String contents) throws Exception
   {
       NoteDB db = new NoteDB();
       Note note = db.get(noteid);
       note.setTitle(title);
       note.setContents(contents);
      
       db.update(note); 
   }
   
    public void delete(int noteid) throws Exception {
       NoteDB db = new NoteDB();
       Note note = db.get(noteid);
       
       db.delete(note);
    }
    public void insert(String contents, String title) throws Exception {
        NoteDB db = new NoteDB();
        //pass a dummy note id of 0 and the current date/time for date created to the DB layer
          // all new users are regular users
         
 
        Date date = new Date();
        Note note= new Note(0, date, contents, title);
        
        db.insert(note);
        
    }
}

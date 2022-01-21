package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//fetch title and content here
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(title, content, new Date());
			
			//System.out.println(note.getId()+" : "+note.getTitle());
			//hibernate:save()
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.save(note);
			tx.commit();
			
			
			
			s.close();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			response.sendRedirect("redirect.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    public SaveNoteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	

}

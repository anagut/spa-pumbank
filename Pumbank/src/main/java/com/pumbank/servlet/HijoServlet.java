package com.pumbank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pumbank.models.Hijx;
import com.pumbank.persistance.HijoManager;


public class HijoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("hid");
		
		
		try {
			int hid=Integer.parseInt(id);
			Hijx hijo = HijoManager.getInstance().getHijo(hid);
			request.setAttribute("unH", hijo);
			
		} catch (Exception e) {
			
			System.out.println("Exception: " + e.getMessage());
			request.setAttribute("error", "Tu no eres Xadre");
		}
		request.getRequestDispatcher("/hijo.jsp").forward(request, response);

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

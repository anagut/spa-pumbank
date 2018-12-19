package com.pumbank.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.persistance.PadreManager;

public class PadreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PadreServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pid =request.getParameter("pid");
		
		
		try {
			int pidint = Integer.parseInt(pid);
			Padre padre = PadreManager.getInstance().getPadre(pidint);
			request.setAttribute("unP", padre);
//			List<Hijx> listaHijos = PadreManager.getInstance().dameTodosLosHijxs();
//			request.setAttribute("hijos", listaHijos);
		

			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			request.setAttribute("error", "Tu no eres Xadre");

		}
		
		request.getRequestDispatcher("/padre.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

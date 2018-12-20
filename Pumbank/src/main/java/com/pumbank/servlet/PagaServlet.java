package com.pumbank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.models.Paga;
import com.pumbank.persistance.HijoManager;
import com.pumbank.persistance.PadreManager;
import com.pumbank.persistance.PagaManager;

public class PagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pidrecibido = request.getParameter("pid");
		int pidrec = Integer.parseInt(pidrecibido);
			
		String hidrecibido = request.getParameter("hid");
		int hidrec = Integer.parseInt(hidrecibido);
		
		try {
			Padre padre = PadreManager.getInstance().getPadre(pidrec);
			request.setAttribute("elPadre", padre);
			
			Paga pagaExistente = PagaManager.getInstance().existePaga(hidrec);
			
			if (pagaExistente != null) {

				Hijx elhijo = HijoManager.getInstance().getHijo(hidrec);
				request.setAttribute("elHijo", elhijo);
				request.setAttribute("laPaga", pagaExistente);
				request.getRequestDispatcher("/paga.jsp").forward(request, response);
			}else {
				Hijx elhijo = HijoManager.getInstance().getHijo(hidrec);
				request.setAttribute("elHijo", elhijo);
				request.getRequestDispatcher("/paga.jsp").forward(request, response);
			}
					

			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			request.setAttribute("error", "Ooops, ha habido un error. Inténtelo más tarde.");
			request.getRequestDispatcher("/paga.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String hidrecibido = request.getParameter("hid");
		int hidrec = Integer.parseInt(hidrecibido);
		
		String pgidrecibido = request.getParameter("pgid");
		int pgidrec = (pgidrecibido!=null && !pgidrecibido.equals(""))?Integer.parseInt(pgidrecibido):0;
		
		String cantidadrec = request.getParameter("cantidad");
		double cantidad = Double.parseDouble(cantidadrec);
		
		String frecuenciarec = request.getParameter("frecuencia");
		int frecuencia = Integer.parseInt(frecuenciarec);
		
		String pidrecibido = request.getParameter("pid");
		int pidrec = Integer.parseInt(pidrecibido);
		

		try {
			Paga unaPaga = new Paga(pgidrec, cantidad, frecuencia, pidrec, hidrec);
			
			if (pgidrec == 0) {
				
				
				System.out.println(unaPaga);
				
				PagaManager.getInstance().createPaga(unaPaga);
			}else {
				PagaManager.getInstance().updatePaga(unaPaga);
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
		doGet(request, response);
	}

}

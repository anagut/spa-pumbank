package com.pumbank.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pumbank.models.Congelar;
import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.persistance.CongelarManager;
import com.pumbank.persistance.HijoManager;
import com.pumbank.persistance.PadreManager;

public class CongelarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hidrec = request.getParameter("hid");
		String pidrec = request.getParameter("pid");
		
		try {
			int hid = Integer.parseInt(hidrec);
			int pid = Integer.parseInt(pidrec);

			Hijx hijo = HijoManager.getInstance().getHijo(hid);
			Padre padre = PadreManager.getInstance().getPadre(pid);
			
			request.setAttribute("unH", hijo);
			request.setAttribute("elPadre", padre);
			
			request.getRequestDispatcher("/congelar.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			request.setAttribute("error", "Ooops, ha habido un error. Inténtelo más tarde.");
			request.getRequestDispatcher("/congelar.jsp").forward(request, response);
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fecha_inicio = request.getParameter("fecha_inicio");
		String fecha_fin = request.getParameter("fecha_fin");
		String hid = request.getParameter("hid");
		String pid=request.getParameter("pid");

		System.out.println("Fechas:" + fecha_inicio + fecha_fin);

		try {

			int hid1 = Integer.parseInt(hid);
			int pid1=Integer.parseInt(pid);

			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date fecha_inicio_D = format.parse(fecha_inicio);
			System.out.println(fecha_inicio_D);

			Date fecha_fin_D = format.parse(fecha_fin);
			System.out.println(fecha_fin_D);

			Congelar congelado = new Congelar();

			congelado.setFecha_inicio(fecha_inicio_D);

			congelado.setFecha_fin(fecha_fin_D);

			congelado.setHid(hid1);

			congelado.setPid(pid1);
			
			System.out.println(congelado);

			CongelarManager.getInstance().createCongelar(congelado);
			
			Hijx hijo = HijoManager.getInstance().getHijo(hid1);
			request.setAttribute("unH", hijo);
							
			request.setAttribute("daleCongelado", congelado);
			request.setAttribute("mensaje", "La cuenta ha sido congelada.");
			request.getRequestDispatcher("/congelar.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			request.setAttribute("error", "Ooops, ha habido un error. Inténtelo más tarde.");
			request.getRequestDispatcher("/congelar.jsp").forward(request, response);
					
		}
		
		doGet(request, response);
	}

}

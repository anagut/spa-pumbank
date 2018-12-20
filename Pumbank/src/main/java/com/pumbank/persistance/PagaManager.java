package com.pumbank.persistance;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pumbank.models.Paga;
import com.pumbank.models.StatusMessage;

public class PagaManager {

	private static PagaManager instance = null;
	private static SessionFactory sf = null;

	public static PagaManager getInstance() throws Exception {
		if (instance == null)
			instance = new PagaManager();

		return instance;
	}

	private PagaManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public Paga existePaga(int hid) throws Exception {

		Paga paga = null;
		List<Paga> pagas = null;

		Session session = sf.openSession();

		pagas = session.createQuery("FROM Paga").list();

		for (Paga unaPaga : pagas) {
			if (unaPaga.getHid() == hid) {
				paga = unaPaga;
				break;
			}
		}

//		session.close();
		return paga;

	}

	public static Paga getPaga(int pgid) throws Exception {

		Session session = sf.openSession();

		Paga paga = session.get(Paga.class, pgid);

		session.close();
		return paga;

	}



	public Paga addPaga(Paga unaPaga) throws Exception {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int pgid = ((Integer) session.save(unaPaga)).intValue();
		unaPaga.setPgid(pgid);

		t.commit();
		session.close();

		return unaPaga;
	}

	public void actualizarPaga(Paga unaPaga) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.update(unaPaga);

		t.commit();
		session.close();

	}
	
	public boolean deletePaga(int pgid) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Paga unaPaga= session.find(Paga.class, pgid);
		session.delete(unaPaga);
		
		t.commit();
		session.close();
		return true;
	}
	
	
	
	@Path("/hijos/{hid}/paga")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPaga(Paga unaPaga) {
		Response resp = null;
		try {
			PagaManager pm = PagaManager.getInstance();
			if (unaPaga.validate()) {
				pm.addPaga(unaPaga);
				resp = Response.status(200).entity(pm.addPaga(unaPaga)).build();
			} else {
				resp = Response.status(400).entity(new StatusMessage(400, "Pedido incompleto")).build();
			}
		} catch (Exception e) {
			resp = Response.status(500).entity(new StatusMessage(500, "oops")).build();
		}
		return resp;
	}

	@Path("/hijos/{hid}/paga/{pgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaga(@PathParam("pgid") int pgid) {

		try {
			Paga pagadevuelta = PagaManager.getPaga(pgid);
			return Response.status(200).entity(pagadevuelta).build();
		} catch (Exception e) {
			return Response.status(400).entity(new StatusMessage(400, "No hay paga")).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarPaga(@PathParam("pgid") int pgid, Paga pagaAct) {

		try {
			actualizarPaga(pgid, pagaAct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deletePaga(@PathParam("pgid") int pgid) {
		try {
		deletePaga(pgid);
		return true;
		}catch (Exception e){
		return false;
	}
		}

}

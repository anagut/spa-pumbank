package com.pumbank.services;

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

import com.pumbank.models.Congelar;
import com.pumbank.models.Paga;
import com.pumbank.models.StatusMessage;
import com.pumbank.persistance.CongelarManager;
import com.pumbank.persistance.PagaManager;

public class CarlosService {

	
	@Path("/hijos/{hid}/congelar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCongelado (Congelar nuevoCongelado ) {
		Response resp = null;
		try {
			CongelarManager pm = CongelarManager.getInstance();
			if (nuevoCongelado.validate()) {
				pm.createCongelar(nuevoCongelado);
				resp = Response.status(200).entity(pm.createCongelar(nuevoCongelado)).build();
			} else {
				resp = Response.status(400).entity(new StatusMessage(400, "Pedido incompleto")).build();
			}
		} catch (Exception e) {
			resp = Response.status(500).entity(new StatusMessage(500, "oops")).build();
		}
		return resp;
	}
	
	@Path("/hijos/{hid}/congelar/{cid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCongelado(@PathParam("cid") int cid) {
		try {
			Congelar congelado = CongelarManager.getInstance().getCongelar(cid);
			return Response.status(200).entity(congelado).build();
		} catch (Exception e) {
			return Response.status(400).entity(new StatusMessage(400, "No hay paga")).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarCongelado (@PathParam("cid") int cid, Congelar congelarAct) {
		return false;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCongelado(@PathParam("cid") int cid) {
		return null;
	}
	
}

package com.pumbank.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.models.StatusMessage;
import com.pumbank.persistance.HijoManager;
import com.pumbank.persistance.PadreManager;

public class AnaService {

//padre/{pid}
	@GET
	public Response getPadre(@PathParam("pid") int pid) {

		Response resp = null;
		Padre padre = PadreManager.getInstance().getPadre(pid);

		if (padre == null) {
			resp = Response.status(404).entity(new StatusMessage(404, "El usuario padre no existe")).build();
		} else {
			resp = Response.status(200).entity(padre).build();
		}

		return resp;
	}

//padre/{pid}/hijos
@GET
public Response getHijos(@PathParam("pid") int pid) {
	Padre padre = PadreManager.getInstance().getPadre(pid);
	
	List<Hijx> hijos = padre.getHijos();
	
	return Response.status(200).entity(hijos).build();
}

	@POST
	public Response addHijo(Hijx hijo) {
		Response resp = null;

		if (hijo.validate()) {

			int hid = HijoManager.getInstance().createHijo(hijo);

			hijo.setHid(hid);

			resp = Response.status(200).entity(hijo).build();

		} else {
			resp = Response.status(400).entity(new StatusMessage(400, "No se han rellenado los datos correctamente"))
					.build();
		}

		return resp;
	}

//padre/{pid}/hijos/{hid}
	public Response getHijo(@PathParam("hid") int hid) {

		Response resp = null;
		Hijx hijo = HijoManager.getInstance().getHijo(hid);

		if (hijo == null) {
			resp = Response.status(404).entity(new StatusMessage(404, "El hijo no existe")).build();
		} else {
			resp = Response.status(200).entity(hijo).build();
		}

		return resp;

	}

@PUT
public boolean actualizarHijo(@PathParam("hid") int hid, Hijx hijo) {
	
	try {
		HijoManager.getInstance().updateHijo(hijo);
		return true;
	} catch (Exception e) {
		System.out.println("Error catch:"+e.getMessage());
		e.printStackTrace();
		return false;
	}
}


	

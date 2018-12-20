package com.pumbank.services;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.models.StatusMessage;
import com.pumbank.persistance.HijoManager;
import com.pumbank.persistance.PadreManager;
import com.ricardo.persistence.PedidosManager;



public class AnaService {
	
//padre/{pid}
@GET
	public Response getPadre(@PathParam("pid") int pid) throws Exception {
		
		Response resp = null;
		Padre padre = PadreManager.getInstance().getPadre(pid);
		
		if (padre == null) {
			resp = Response.status(404).entity(new StatusMessage(404, "El usuario padre no existe")).build();
		} else {
			resp = Response.status(200).entity(padre).build();
		}

		return resp;
	}
}


//padre/{pid}/hijos
@GET
public Response getHijos(@PathParam("pid") int pid) throws Exception) {
	Padre padre = PadreManager.getInstance().getPadre(pid);
	
	List<Hijx> hijos = padre.getHijos();
	
	return Response.status(200).entity(hijos).build();
}

@POST
public Response addHijo(Hijx hijo) {
	Response resp = null;
	
	if (hijo.validate()) {
		HijoManager.getInstance().createHijo(hijo);
		
		resp = Response.status(200).entity(hijo).build();
		
	} else {
		resp = Response.status(400).entity(new StatusMessage(400, "No se han rellenado los datos correctamente")).build();
	}

	return resp;
}


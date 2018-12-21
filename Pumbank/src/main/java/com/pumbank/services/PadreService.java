package com.pumbank.services;

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

import com.pumbank.models.Congelar;
import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.models.Paga;
import com.pumbank.models.StatusMessage;
import com.pumbank.persistance.CongelarManager;
import com.pumbank.persistance.HijoManager;
import com.pumbank.persistance.PadreManager;
import com.pumbank.persistance.PagaManager;

@Path("/padre/{pid}")
public class PadreService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPadre(@PathParam("pid") int pid) {

		Response resp = null;
		Padre padre;
		try {
			padre = PadreManager.getInstance().getPadre(pid);

			if (padre == null) {
				resp = Response.status(404).entity(new StatusMessage(404, "El usuario padre no existe")).build();
			} else {
				resp = Response.status(200).entity(padre).build();
			}
		} catch (Exception e) {
			System.out.println("Error catch:" + e.getMessage());
			e.printStackTrace();
		}

		return resp;
	}

	@Path("/hijos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHijos(@PathParam("pid") int pid) {
		Padre padre;
		try {
			padre = PadreManager.getInstance().getPadre(pid);

			List<Hijx> hijos = padre.getHijos();

			return Response.status(200).entity(hijos).build();

		} catch (Exception e) {
			System.out.println("Error catch:" + e.getMessage());
			e.printStackTrace();
			return Response.status(404).entity(new StatusMessage(404, "No se ha encontrado lo que buscas")).build();
		}

	}

	@Path("/hijos")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addHijo(Hijx hijo,@PathParam("pid") int pid) {
		Response resp = null;

		
			try {
				HijoManager.getInstance().createHijo(hijo);
				resp = Response.status(200).entity(hijo).build();
			} catch (Exception e) {
				System.out.println("Error catch:" + e.getMessage());
				e.printStackTrace();
				resp=  Response.status(403).entity(new StatusMessage(403, "No pasaras")).build();
			}


		return resp;
	}

	@Path("/hijos/{hid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHijo(@PathParam("hid") int hid) {

		Response resp = null;
		Hijx hijo;
		try {
			hijo = HijoManager.getInstance().getHijo(hid);

			if (hijo == null) {
				resp = Response.status(404).entity(new StatusMessage(404, "El hijo no existe")).build();
			} else {
				resp = Response.status(200).entity(hijo).build();
			}
		} catch (Exception e) {
			resp = Response.status(400).entity(new StatusMessage(404, "Quereis problemas? Pues escuchad nuestro lema"))
					.build();
		}

		return resp;
	}

	@Path("/hijos/{hid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean hacerTransferencia( @PathParam("hid") int hid, Hijx hijo) {

		try {
			HijoManager.getInstance().updateHijo(hijo);
			return true;
		} catch (Exception e) {
			System.out.println("Error catch:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Path("/hijos/{hid}/paga")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPaga(Paga unaPaga,@PathParam("pid") int pid, @PathParam("hid") int hid) {
		Response resp = null;
		try {
			PagaManager pm = PagaManager.getInstance();
			if (unaPaga.validate()) {
				unaPaga.setHid(hid);
				unaPaga.setPid(pid);
				pm.addPaga(unaPaga);
				resp = Response.status(200).entity(pm.addPaga(unaPaga)).build();
			} else {
				resp = Response.status(400).entity(new StatusMessage(400, "Pedido incompleto")).build();
			}
		} catch (Exception e) {
			e.getStackTrace();
			resp = Response.status(500).entity(new StatusMessage(500, "oops")).build();

		}
		return resp;
	}

	
	@Path("/hijos/{hid}/paga/{pgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaga(@PathParam("pid") int pid, @PathParam("hid") int hid, @PathParam("pgid") int pgid) {

		try {
			Paga pagadevuelta = PagaManager.getPaga(pgid);
			return Response.status(200).entity(pagadevuelta).build();
		} catch (Exception e) {
			return Response.status(400).entity(new StatusMessage(400, "No hay paga")).build();
		}
	}

	@Path("/hijos/{hid}/paga/{pgid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarPaga(@PathParam("pid") int pid, @PathParam("hid") int hid, @PathParam("pgid") int pgid, Paga pagaAct) {

		try {
			pagaAct.setPid(pid);
			pagaAct.setHid(hid);
			PagaManager.getInstance().actualizarPaga(pagaAct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Path("/hijos/{hid}/paga/{pgid}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deletePaga(@PathParam("pid") int pid, @PathParam("hid") int hid, @PathParam("pgid") int pgid) {
		try {
			PagaManager.getInstance().deletePaga(pgid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Path("/hijos/{hid}/congelar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCongelado(@PathParam("pid") int pid, @PathParam("hid") int hid,Congelar nuevoCongelado) {
		Response resp = null;
		try {
			CongelarManager pm = CongelarManager.getInstance();
			if (nuevoCongelado.validate()) {
				nuevoCongelado.setPid(pid);
				nuevoCongelado.setHid(hid);
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
	public Response getCongelado(@PathParam("pid") int pid, @PathParam("hid") int hid, @PathParam("cid") int cid) {
		try {
			Congelar congelado = CongelarManager.getInstance().getCongelar(cid);
			return Response.status(200).entity(congelado).build();
		} catch (Exception e) {
			return Response.status(400).entity(new StatusMessage(400, "No hay paga")).build();
		}
	}

	@Path("/hijos/{hid}/congelar/{cid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarCongelado(@PathParam("pid") int pid, @PathParam("hid") int hid, @PathParam("cid") int cid, Congelar congelarAct) {
		try {
			congelarAct.setPid(pid);
			congelarAct.setHid(hid);
			CongelarManager.getInstance().updateCongelar(congelarAct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Path("/hijos/{hid}/congelar/{cid}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteCongelado(@PathParam("pid") int pid, @PathParam("hid") int hid, @PathParam("cid") int cid) {
		try {
			CongelarManager.getInstance().deleteCongelar(cid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

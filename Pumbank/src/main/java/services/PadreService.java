package services;

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
import com.pumbank.models.Paga;

@Path("/padre/{pid}")
public class PadreService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPadre(@PathParam("pid") int pid) {
		return null;}
	
	@Path("/hijos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHijos() {
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addHijo (Hijx hijoNuevo) {
		return null;
	}
	
	@Path("/hijos/{hid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHijo(int hid) {
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean hacerTransferencia (int saldo, Hijx unHijo) {
		return false;
	}
	
	@Path("/hijos/{hid}/paga")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPaga (Paga unaPaga) {
		return null;
	}
	
	@Path("/hijos/{hid}/paga/{pgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaga(@PathParam("pgid") int pgid) {
		return null;		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarPaga (@PathParam("pgid") int pgid, Paga pagaAct) {
		return false;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePaga(@PathParam("pgid") int pgid) {
		return null;
	}
	
	
	@Path("/hijos/{hid}/congelar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCongelado (Congelar nuevoCongelado ) {
		return null;
	}
	
	@Path("/hijos/{hid}/congelar/{cid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCongelado(@PathParam("cid") int cid) {
		return null;		
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

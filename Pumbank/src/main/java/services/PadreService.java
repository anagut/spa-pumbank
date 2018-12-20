package services;

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
import com.pumbank.persistance.HijoManager;
import com.pumbank.persistance.PadreManager;

@Path("/padre/{pid}")
public class PadreService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPadre(@PathParam("pid") int pid){
		
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
			System.out.println("Error catch:"+e.getMessage());
			e.printStackTrace();
		}
		
		

		return resp;
	}
	
	@Path("/hijos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHijos(@PathParam("pid") int pid){
		Padre padre;
		try {
			padre = PadreManager.getInstance().getPadre(pid);
			
			List<Hijx> hijos = padre.getHijos();
			
			return Response.status(200).entity(hijos).build();
			
		} catch (Exception e) {
			System.out.println("Error catch:"+e.getMessage());
			e.printStackTrace();
			return Response.status(404).entity().build();
		}
		

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addHijo(Hijx hijo) {
		Response resp = null;
		
		if (hijo.validate()) {
			try {
				HijoManager.getInstance().createHijo(hijo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp = Response.status(200).entity(hijo).build();
			
		} else {
			resp = Response.status(400).entity(new StatusMessage(400, "No se han rellenado los datos correctamente")).build();
		}

		return resp;
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

package ec.edu.ups.rest;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Restaurante;

@Path("/restaurante/")

public class GestionRestaurantes {
	@EJB
    RestauranteFacade restauranteFacade;
	private Restaurante restaurante;
	
	
	
	@POST
    @Path("/registrarRestaurante/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(
    		@FormParam("nombre") String nombre,
    		@FormParam("direccion") String direccion,
    		@FormParam("telefono") String telefono,
    		@FormParam("maxAforo") int maxAforo

    		){
		restaurante = new Restaurante();
        Jsonb jsonb = JsonbBuilder.create();
        restaurante.setNombre(nombre);
        restaurante.setDireccion(direccion);
        restaurante.setTelefono(telefono);
        restaurante.setMaxAforo(maxAforo);
            
            try{
    			String ok ="Se registró un restaurante con éxito";
                restauranteFacade.create(restaurante);
                return Response.ok(jsonb.toJson(ok)).
                		header("Access-Control-Allow-Origin", "*")
    					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
                
            }catch (Exception e){
                return Response.status(500).entity("Error al registrar un restaurante " + e).build();
            }
       
    }
	
}

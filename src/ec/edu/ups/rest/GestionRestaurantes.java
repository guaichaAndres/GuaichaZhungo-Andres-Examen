package ec.edu.ups.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Restaurante;

@Path("/restaurante/")

public class GestionRestaurantes {
	@EJB
    RestauranteFacade restauranteFacade;
	private Restaurante restaurante;
	@EJB
    ReservaFacade reservaFacade;
	private Reserva reserva;
	
	
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
	
	@GET
    @Path("/reservas/{nombreRestaurante}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarReservasNombre(@PathParam("nombreRestaurante") String nombre) {
        System.out.println(nombre);
        try {
            List<Reserva> reservas = new ArrayList<Reserva>();
            Jsonb jsonb = JsonbBuilder.create();
            reservas = reservaFacade.buscarPorNombre(nombre);
           
            
            if(reservas.size()!=0) {
                return Response.ok(jsonb.toJson(reservas))
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
            }else {
                return Response.status(404).entity("El usuario no tiene ninguna reserva").build();
            }


        } catch (Exception e) {
            return Response.status(404).entity("Usuario no encontrado").build();
        }
	
	}
	
	@GET
    @Path("/reservaciones/{fecha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarReservasFecha(@PathParam("fecha") String fecha) {
        System.out.println(fecha);
        try {
            List<Reserva> reservas = new ArrayList<Reserva>();
            Jsonb jsonb = JsonbBuilder.create();
            reservas = reservaFacade.buscarPorFecha(fecha);
           
            
            if(reservas.size()!=0) {
                return Response.ok(jsonb.toJson(reservas))
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
            }else {
                return Response.status(404).entity("El usuario no tiene ninguna reserva").build();
            }


        } catch (Exception e) {
            return Response.status(404).entity("Usuario no encontrado").build();
        }
	
	}
	
	@GET
    @Path("/existeRestaurante/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response existeCliente(@PathParam("nombre") String nombre) {
        System.out.println(nombre);
        try {
            Restaurante res = new Restaurante();
            Jsonb jsonb = JsonbBuilder.create();
            res = restauranteFacade.buscarRestaurantePorNombre(nombre);
           String respuesta="true";
            if(res != null) {
                return Response.ok(jsonb.toJson(respuesta))
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
            }else {
                return Response.status(404).entity("El restaurante no existe").build();
            }


        } catch (Exception e) {
            return Response.status(404).entity("Restaurante no encontrado").build();
        }
	
	}
	
}

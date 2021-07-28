package ec.edu.ups.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Restaurante;

@Path("/reserva/")
public class GestionReservas {
	@EJB
    ReservaFacade reservasFacade;
	private Reserva reserva;
	@EJB
    PersonaFacade personaFacade;
	private Persona persona;
	@EJB
    RestauranteFacade restauranteFacade;
	private Restaurante restaurante;
	
	Date  fecha;
	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 
	 
	@POST
    @Path("/crearReserva/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(
    		@FormParam("cedula") String cedula, 
    		@FormParam("nombre") String nombre, 
    		@FormParam("numPersonas") int numPersonas
    		){
        Jsonb jsonb = JsonbBuilder.create();
        
        try {
            restaurante = restauranteFacade.buscarRestaurantePorNombre(nombre);
            
            persona = personaFacade.buscarCliente(cedula);

        } catch (Exception e) {
            System.out.println("NO se encontro lo necesario");
        }
        if (persona != null && restaurante != null) {
            int capacidad = restaurante.getMaxAforo() - numPersonas;
            if(capacidad > 1){
     
                System.out.println("Hasta aqui"+fecha);
                
              

                reserva = new Reserva(new Date(), numPersonas, persona, restaurante);
                reservasFacade.create(reserva);
                restaurante.setMaxAforo(capacidad);
                restauranteFacade.edit(restaurante);
                String ok ="Se registró una reserva con exito";
                return Response.ok(jsonb.toJson(ok)).
                		header("Access-Control-Allow-Origin", "*")
    					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
               
        } else {
            return Response.status(500).entity("No existe aforo").build();

        }

    } else {
        return Response.status(404).entity("Usuario o restaurante no encontrado").build();

    }
	
	
	}
}


	           


	               

	          


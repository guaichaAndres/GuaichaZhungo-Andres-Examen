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

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Reserva;

@Path("/cliente/")
public class GestionClientes {

	@EJB
    PersonaFacade personaFacade;
	private Persona persona;
	@EJB
    ReservaFacade reservaFacade;
	private Reserva reserva;
	
	@POST
    @Path("/registrarCliente/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(
    		@FormParam("cedula") String cedula,
    		@FormParam("correo") String correo,
    		@FormParam("nombre") String nombre,
    		@FormParam("apellido") String apellido,
    		@FormParam("direccion") String direccion,
    		@FormParam("telefono") String telefono
    		){
		persona = new Persona();
        Jsonb jsonb = JsonbBuilder.create();
        	persona.setCedula(cedula);
            persona.setCorreo(correo);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            
            try{
    			String ok ="Se registró un usuario con éxito";
                personaFacade.create(persona);
                return Response.ok(jsonb.toJson(ok)).
                		header("Access-Control-Allow-Origin", "*")
    					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
    					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
                
            }catch (Exception e){
                return Response.status(500).entity("Error al registrar usuario " + e).build();
            }
       
    }
	
	
	
	@GET
    @Path("/reservas/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarReservasCedula(@PathParam("cedula") String cedula) {
        System.out.println(cedula);
        try {
            List<Reserva> reservas = new ArrayList<Reserva>();
            Persona cli = new Persona();
            Jsonb jsonb = JsonbBuilder.create();
            reservas = reservaFacade.buscarPorCodigo(cedula);  
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
	
	
}

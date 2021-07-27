package ec.edu.ups.rest;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import ec.edu.ups.ejb.ReservaFacade;

import ec.edu.ups.modelo.Reserva;

@Path("/reserva/")
public class GestionReservas {
	@EJB
    ReservaFacade reservasFacade;
	private Reserva reserva;
}

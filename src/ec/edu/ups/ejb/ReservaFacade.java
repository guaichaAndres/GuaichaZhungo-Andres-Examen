package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Reserva;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {
	   @PersistenceContext(unitName = "GuaichaZhungoKelvinAndresExamen")
	    private EntityManager em;
	    
	    public ReservaFacade() {
		super(Reserva.class);
	    }    

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
		
}

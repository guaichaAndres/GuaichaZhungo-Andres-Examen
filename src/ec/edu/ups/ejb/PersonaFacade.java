package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Persona;


@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {
	   @PersistenceContext(unitName = "GuaichaZhungoKelvinAndresExamen")
	    private EntityManager em;
	    
	    public PersonaFacade() {
		super(Persona.class);
	    }    

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	  
		
}

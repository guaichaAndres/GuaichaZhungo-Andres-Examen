package ec.edu.ups.ejb;


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
	  
	    public Persona buscarCliente(String cedula) {
			try {
				String jpql = "SELECT per FROM Persona per WHERE per.cedula="+"'"+cedula+"'";
				Persona per = (Persona) em.createQuery(jpql).getSingleResult();
				return per;
			} catch (Exception e) {
				return null;
			}
		}
}

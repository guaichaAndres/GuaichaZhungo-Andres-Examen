package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Restaurante;

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante> {
	   @PersistenceContext(unitName = "GuaichaZhungoKelvinAndresExamen")
	    private EntityManager em;
	    
	    public RestauranteFacade() {
		super(Restaurante.class);
	    }    

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	    
	    public Restaurante buscarRestaurantePorNombre(String nombre) {
			try {
				String jpql = "SELECT res FROM Restaurante res WHERE res.nombre="+"'"+ nombre+"'";
				Restaurante per = (Restaurante) em.createQuery(jpql).getSingleResult();
				return per;
			} catch (Exception e) {

				return null;
			}
		}
		
}

package ec.edu.ups.ejb;

import java.util.List;

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
	    
	    public List<Reserva> buscarPorCodigo(int cedula) {
			String jpql = "SELECT r FROM Reserva as r ";
			List<Reserva> reserva = em.createQuery(jpql).getResultList();
			System.out.println(reserva);
			return reserva;
		}
}

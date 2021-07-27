package ec.edu.ups.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private int numPersonas;
	@JoinColumn(name = "fk_persona")
	@ManyToOne
	private Persona persona;
	@JoinColumn(name = "fk_restaurante")
	@ManyToOne
	private Restaurante restaurante;
	
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(Date fecha, int numPersonas, Persona persona, Restaurante restaurante) {
		super();
		this.fecha = fecha;
		this.numPersonas = numPersonas;
		this.persona = persona;
		this.restaurante = restaurante;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
}

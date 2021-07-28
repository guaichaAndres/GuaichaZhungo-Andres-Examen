package ec.edu.ups.modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fecha;
	private String hora;
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
	
	public Reserva(String fecha, String hora,int numPersonas,Persona persona, Restaurante restaurante) {
		super();
		this.fecha = fecha;
		this.hora = hora;
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




	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", numPersonas=" + numPersonas + ", persona=" + persona
				+ ", restaurante=" + restaurante + "]";
	}
	
}

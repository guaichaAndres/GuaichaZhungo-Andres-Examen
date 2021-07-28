package ec.edu.ups.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private int maxAforo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
	private List<Reserva> reservas;
	
	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Restaurante(String nombre, String direccion, String telefono,
			int maxAforo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.maxAforo = maxAforo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getMaxAforo() {
		return maxAforo;
	}
	public void setMaxAforo(int maxAforo) {
		this.maxAforo = maxAforo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", maxAforo=" + maxAforo + ", reservas=" + reservas + "]";
	}
	
	
}

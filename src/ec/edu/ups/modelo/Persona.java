package ec.edu.ups.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona {
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String direccion;
	private String telefono;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<Reserva> reservas;
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(String cedula,String nombre, String apellido, String correo, String direccion, 
			String telefono) {
		super();
		this.cedula= cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		
	
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", reservas=" + reservas + "]";
	}

	
	
}

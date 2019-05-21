package pe.edu.upc.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pasajero")
public class Pasajero implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Dni", length = 8, nullable = false)
	private String Dni;
	
	@Column(name = "nombres", length = 30, nullable = false)
	private String nombres;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "asiento", length = 3, nullable = false)
	private String asiento;
	
	@Column(name = "montoPagado")
	private double montoPagado;
	
	@ManyToOne
	@JoinColumn(name = "vueloid", nullable = false)
	private Vuelo vueloid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public Vuelo getVueloid() {
		return vueloid;
	}

	public void setVueloid(Vuelo vueloid) {
		this.vueloid = vueloid;
	}
	
	
}

package pe.edu.upc.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="vuelo")
public class Vuelo implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="codigo",length = 5, nullable = false)
	private String codigo;
	
	@Column(name ="origen", length = 20, nullable = false)
	private String origen;
	
	@Column(name ="destino", length = 20, nullable = false)
	private String destino;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaida")
	private Date fechaida;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechavuelta")
	private Date fechavuelta;
	
	@Column(name ="piloto", length = 30, nullable = false)
	private String piloto;
	
	private Integer servicio;
	private Integer estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getFechaida() {
		return fechaida;
	}
	public void setFechaida(Date fechaida) {
		this.fechaida = fechaida;
	}
	public Date getFechavuelta() {
		return fechavuelta;
	}
	public void setFechavuelta(Date fechavuelta) {
		this.fechavuelta = fechavuelta;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public Integer getServicio() {
		return servicio;
	}
	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
		
	
}

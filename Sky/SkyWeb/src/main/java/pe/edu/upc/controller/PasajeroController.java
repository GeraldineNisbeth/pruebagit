package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.model.entity.Pasajero;
import pe.edu.upc.model.entity.Vuelo;
import pe.edu.upc.service.PasajeroService;
import pe.edu.upc.service.VueloService;
import pe.edu.upc.util.Message;

@Named
@ViewScoped
public class PasajeroController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PasajeroService pasajeroService;
	
	@Inject
	private VueloService vueloService;
	
	private Pasajero pasajero;
	private Pasajero pasajeroSelec;
	private List<Pasajero> pasajeros;
	
	private Vuelo vuelo;
	private List<Vuelo> vuelos;
	
	public void loadPasajeros() {
		try {
			this.pasajeros=pasajeroService.FindAll();
		}catch(Exception e) {
			Message.messageError("Error: "+ e.getMessage());
		}
	}
	public void loadVuelos() {
		try {
			this.vuelos=vueloService.FindAll();
		}catch(Exception e) {
			Message.messageError("Error: "+ e.getMessage());
		}
	}
	
	public void resetForm() {
		this.pasajero= new Pasajero();
		this.pasajeroSelec=null;
	}	
	
	@PostConstruct
	public void init() {
		this.pasajero= new Pasajero();
		this.pasajeroSelec=new Pasajero();
		this.loadPasajeros();
		this.loadVuelos();
	}
	
	public void savePasajero() {
		try {
			if(pasajero.getId() != null){
				this.pasajero.setVueloid(this.vuelo);
				this.pasajeroService.Update(pasajero);
				Message.messageInfo("Update: Exitoso");
			} else {
				this.pasajero.setVueloid(this.vuelo);
				this.pasajeroService.Insert(pasajero);
				Message.messageInfo("Insert: Exitoso");
			}
			this.loadPasajeros();
			this.resetForm();
		}catch(Exception e) {
			Message.messageError("Error: en SAVE de pasajeros "+ e.getMessage());
		}
	}
	
	public void selectPasajero(SelectEvent e) {
		this.pasajeroSelec= (Pasajero) e.getObject();
	}
	
	public void editPasajero()
	{
		try {
			if(this.pasajeroSelec != null)
			{
				this.pasajero=this.pasajeroSelec;
			} else {
				Message.messageError("Error: Seleccione pasajero a editar ");
			}
		}catch(Exception e) {
			Message.messageError("Error: en EDIT de pasajeros "+ e.getMessage());
		}
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public Pasajero getPasajeroSelec() {
		return pasajeroSelec;
	}
	public void setPasajeroSelec(Pasajero pasajeroSelec) {
		this.pasajeroSelec = pasajeroSelec;
	}
	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	
}

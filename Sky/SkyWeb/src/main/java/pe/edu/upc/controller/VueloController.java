package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.model.entity.Vuelo;
import pe.edu.upc.service.VueloService;
import pe.edu.upc.util.Message;

@Named
@ViewScoped
public class VueloController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private VueloService vueloService;
	
	private Vuelo vuelo;
	private Vuelo vueloSelec;
	private List<Vuelo> vuelos;
	
	public void loadVuelos() {
		try {
			this.vuelos=vueloService.FindAll();
		}catch(Exception e) {
			Message.messageError("Error: "+ e.getMessage());
		}
	}
	
	public void resetForm() {
		this.vuelo= new Vuelo();
		this.vueloSelec=null;
	}
	
	@PostConstruct
	public void init() {
		this.vuelo= new Vuelo();
		this.vueloSelec=new Vuelo();
		this.loadVuelos();
	}
	
	public void saveVuelo() {
		try {
			if(vuelo.getId() != null){
				this.vueloService.Update(vuelo);
				Message.messageInfo("Update: Exitoso");
			} else {
				this.vueloService.Insert(vuelo);
				Message.messageInfo("Insert: Exitoso");
			}
			this.loadVuelos();
			this.resetForm();
		}catch(Exception e) {
			Message.messageError("Error: en SAVE de vuelos "+ e.getMessage());
		}
	}
	
	public void selectVuelo(SelectEvent e) {
		this.vueloSelec= (Vuelo) e.getObject();
	}
	
	public void editVuelo()
	{
		try {
			if(this.vueloSelec != null)
			{
				this.vuelo=this.vueloSelec;
			} else {
				Message.messageError("Error: Seleccione vuelo a editar ");
			}
		}catch(Exception e) {
			Message.messageError("Error: en EDIT de vuelos "+ e.getMessage());
		}
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Vuelo getVueloSelec() {
		return vueloSelec;
	}

	public void setVueloSelec(Vuelo vueloSelec) {
		this.vueloSelec = vueloSelec;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
}

package pe.edu.upc.service;

import pe.edu.upc.model.entity.Vuelo;

public interface VueloService extends CrudService<Vuelo> {
	Vuelo FindByCodigo(String codigo) throws Exception;
}

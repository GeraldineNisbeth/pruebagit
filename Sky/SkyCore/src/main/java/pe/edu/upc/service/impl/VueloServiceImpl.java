package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.model.entity.Vuelo;
import pe.edu.upc.repository.VueloRepository;
import pe.edu.upc.service.VueloService;

@Named
public class VueloServiceImpl implements VueloService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private VueloRepository vueloRepo;
	
	@Transactional
	@Override
	public Integer Insert(Vuelo t) throws Exception {
		return vueloRepo.Insert(t);
	}

	@Transactional
	@Override
	public Integer Update(Vuelo t) throws Exception {
		return vueloRepo.Update(t);
	}

	@Transactional
	@Override
	public Integer Delete(Vuelo t) throws Exception {
		return vueloRepo.Delete(t);
	}

	@Override
	public List<Vuelo> FindAll() throws Exception {
		return vueloRepo.FindAll();
	}

	@Override
	public Vuelo FindById(Vuelo t) throws Exception {
		return vueloRepo.FindById(t);
	}

	@Override
	public Vuelo FindByCodigo(String codigo) throws Exception {
		return vueloRepo.FindByCodigo(codigo);
	}

}

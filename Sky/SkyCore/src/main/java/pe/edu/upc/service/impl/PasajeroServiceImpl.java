package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.model.entity.Pasajero;
import pe.edu.upc.repository.PasajeroRepository;
import pe.edu.upc.service.PasajeroService;

public class PasajeroServiceImpl implements PasajeroService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PasajeroRepository pasajeroRepo;
	
	@Transactional
	@Override
	public Integer Insert(Pasajero t) throws Exception {
		return pasajeroRepo.Insert(t);
	}

	@Transactional
	@Override
	public Integer Update(Pasajero t) throws Exception {
		return pasajeroRepo.Update(t);
	}

	@Transactional
	@Override
	public Integer Delete(Pasajero t) throws Exception {
		return pasajeroRepo.Delete(t);
	}

	@Override
	public List<Pasajero> FindAll() throws Exception {
		return pasajeroRepo.FindAll();
	}

	@Override
	public Pasajero FindById(Pasajero t) throws Exception {
		return pasajeroRepo.FindById(t);
	}

}

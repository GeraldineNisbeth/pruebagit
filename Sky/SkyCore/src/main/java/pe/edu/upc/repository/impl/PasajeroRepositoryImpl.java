package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Pasajero;
import pe.edu.upc.repository.PasajeroRepository;


@Named
public class PasajeroRepositoryImpl implements PasajeroRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "SkyPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Pasajero t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Pasajero t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Pasajero t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Pasajero> FindAll() throws Exception {
		List<Pasajero> pasajeros=new ArrayList<>();
		TypedQuery<Pasajero> query=em.createQuery("SELECT p FROM Pasajero p",Pasajero.class);
		pasajeros=query.getResultList();
		return pasajeros;
	}

	@Override
	public Pasajero FindById(Pasajero t) throws Exception {
		List<Pasajero> pasajeros=new ArrayList<>();
		
		TypedQuery<Pasajero> query=em.createQuery("SELECT p FROM Pasajero p WHERE p.id=?1", Pasajero.class);
		query.setParameter(1, t.getId());
		pasajeros=query.getResultList();
		
		if(pasajeros!=null && !pasajeros.isEmpty()) {
			return pasajeros.get(0);
		}
		else {
			return new Pasajero();
		}
	}

}

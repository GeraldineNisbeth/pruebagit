package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Vuelo;
import pe.edu.upc.repository.VueloRepository;


@Named
public class VueloRepositoryImpl implements VueloRepository, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "SkyPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Vuelo t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Vuelo t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Vuelo t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Vuelo> FindAll() throws Exception {
		List<Vuelo> vuelos=new ArrayList<>();
		
		TypedQuery<Vuelo> query=em.createQuery("SELECT v FROM Vuelo v", Vuelo.class);
		vuelos=query.getResultList();
		
		return vuelos;
	}

	@Override
	public Vuelo FindById(Vuelo t) throws Exception {
		List<Vuelo> vuelos=new ArrayList<>();
		
		TypedQuery<Vuelo> query=em.createQuery("SELECT v FROM Vuelo v WHERE v.id=?1", Vuelo.class);
		query.setParameter(1, t.getId());
		vuelos=query.getResultList();
		
		if(vuelos!=null && !vuelos.isEmpty()){
			return vuelos.get(0);
		}
		else {
			return new Vuelo();
		}

	}

	@Override
	public Vuelo FindByCodigo(String codigo) throws Exception {
List<Vuelo> vuelos=new ArrayList<>();
		
		TypedQuery<Vuelo> query=em.createQuery("SELECT v FROM Vuelo v WHERE v.codigo=?1", Vuelo.class);
		query.setParameter(1, codigo.toUpperCase());
		vuelos=query.getResultList();
		
		if(vuelos!=null && !vuelos.isEmpty()){
			return vuelos.get(0);
		}
		else {
			return new Vuelo();
		}
	}
	
}

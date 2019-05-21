package pe.edu.upc.repository;

import pe.edu.upc.model.entity.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo> {
	Vuelo FindByCodigo(String codigo) throws Exception;
}

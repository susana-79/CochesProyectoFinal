package susanna.CochesCrudSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import susanna.CochesCrudSpring.model.Coches;

public interface CochesRepository extends JpaRepository<Coches, Integer>{

	

	Iterable<Coches> findByMarcaContainingIgnoreCase(String keyword);
	Iterable<Coches> findByModeloContainingIgnoreCase(String keyword);
	

	
	
}

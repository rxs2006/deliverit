package br.com.deliver.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.deliver.it.model.MultaPorAtraso;

@Repository
public interface MultaPorAtrasoRepository extends JpaRepository<MultaPorAtraso, Integer> {

	@Query(value = "SELECT * FROM multaporatraso WHERE :diasDeAtraso <= diasematraso ORDER BY diasematraso ASC LIMIT 1", nativeQuery = true)
	MultaPorAtraso selecionarParaCalculoValorAtualizado(Long diasDeAtraso);
	
}

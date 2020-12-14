package br.com.deliver.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliver.it.model.MultaPorAtraso;

@Repository
public interface MultaPorAtrasoRepository extends JpaRepository<MultaPorAtraso, Integer> {

}

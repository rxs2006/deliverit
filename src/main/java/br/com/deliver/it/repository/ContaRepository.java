package br.com.deliver.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliver.it.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}

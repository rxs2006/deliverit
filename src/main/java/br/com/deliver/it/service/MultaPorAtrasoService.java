package br.com.deliver.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliver.it.model.MultaPorAtraso;
import br.com.deliver.it.repository.MultaPorAtrasoRepository;

@Service
public class MultaPorAtrasoService {
	@Autowired
	private MultaPorAtrasoRepository multaPorAtrasoRepository;
	
	public MultaPorAtraso salvar(MultaPorAtraso multaPorAtraso)
	{
		return multaPorAtrasoRepository.save(multaPorAtraso);
	}
	
	public List<MultaPorAtraso> findAll()
	{
		return multaPorAtrasoRepository.findAll();
	}	
}

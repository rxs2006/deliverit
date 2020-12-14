package br.com.deliver.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliver.it.model.Conta;
import br.com.deliver.it.repository.ContaRepository;
import br.com.deliver.it.repository.MultaPorAtrasoRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MultaPorAtrasoRepository multaRepository;	
	
	public List<Conta> findAll()
	{
		return contaRepository.findAll();
	}
	
	public Conta salvar(Conta conta)
	{
		if(multaRepository.count() == 0)
		{
			
		}
		
		return contaRepository.save(conta);
	}
	
	public void excluir(Integer id)
	{
		contaRepository.delete(new Conta(id));
	}	
}

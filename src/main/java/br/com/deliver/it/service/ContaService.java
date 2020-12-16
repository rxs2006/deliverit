package br.com.deliver.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliver.it.model.Conta;
import br.com.deliver.it.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta> findAll()
	{
		return contaRepository.findAll();
	}
	
	public Conta salvar(Conta conta)
	{		
		return contaRepository.save(conta);
	}
	
	public void excluir(Integer id)
	{
		contaRepository.delete(new Conta(id));
	}	
}

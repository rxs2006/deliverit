package br.com.deliver.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.it.model.Conta;
import br.com.deliver.it.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@GetMapping("/")
	public List<Conta> findAll()
	{
		return contaService.findAll();
	}
	
	@PostMapping("/")
	public Conta salvar(@RequestBody Conta conta)
	{
		return contaService.salvar(conta);
	}	
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id)
	{
		contaService.excluir(id);
	}		
	
}

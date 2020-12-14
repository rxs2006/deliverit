package br.com.deliver.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.deliver.it.model.MultaPorAtraso;
import br.com.deliver.it.service.MultaPorAtrasoService;

public class MultaPorAtrasoController {
	@Autowired
	private MultaPorAtrasoService multaPorAtrasoService;
	
	@GetMapping("/")
	public List<MultaPorAtraso> findAll()
	{
		return multaPorAtrasoService.findAll();
	}
	
	@PostMapping("/")
	public MultaPorAtraso salvar(@RequestBody MultaPorAtraso multaPorAtraso)
	{
		return multaPorAtrasoService.salvar(multaPorAtraso);
	}	
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id)
	{
		multaPorAtrasoService.excluir(id);
	}	
}

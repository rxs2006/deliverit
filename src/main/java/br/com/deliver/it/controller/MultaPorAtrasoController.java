package br.com.deliver.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.it.model.MultaPorAtraso;
import br.com.deliver.it.service.MultaPorAtrasoService;

@RestController
@RequestMapping("/multas-por-atraso")
public class MultaPorAtrasoController {
	@Autowired
	private MultaPorAtrasoService multaPorAtrasoService;
	
	@PostMapping("/")
	public MultaPorAtraso salvar(@RequestBody MultaPorAtraso multaPorAtraso)
	{
		return multaPorAtrasoService.salvar(multaPorAtraso);
	}	
	
	@GetMapping("/")
	public List<MultaPorAtraso> selecionarTodos()
	{
		return multaPorAtrasoService.findAll();
	}		
}

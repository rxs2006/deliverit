package br.com.deliver.it.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.it.controller.entity.ContaDTO;
import br.com.deliver.it.model.Conta;
import br.com.deliver.it.model.MultaPorAtraso;
import br.com.deliver.it.service.ContaService;
import br.com.deliver.it.service.MultaPorAtrasoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@Autowired
	private MultaPorAtrasoService multaPorAtrasoService;
	
	@GetMapping("/")
	@ApiOperation("Lista as contas cadastradas")
	public List<ContaDTO> findAll()
	{
		ModelMapper mapper = new ModelMapper();
		List<ContaDTO> listaContaDTO = contaService.findAll().stream().map(x -> mapper.map(x, ContaDTO.class)).collect(Collectors.toList());
		
		for(ContaDTO contaDTO : listaContaDTO)
		{
			MultaPorAtraso multaPorAtraso = multaPorAtrasoService.selecionarParaCalculoValorAtualizado(contaDTO.getQuantidadeDeDiasDeAtraso());
			BigDecimal valorDaMulta = contaDTO.getValorOriginal().divide(BigDecimal.valueOf(100)).multiply(multaPorAtraso.getMulta());
			BigDecimal jurosProporcionais = contaDTO.getValorOriginal().divide(BigDecimal.valueOf(100)).multiply(multaPorAtraso.getJuros())
					                        .multiply(BigDecimal.valueOf(contaDTO.getQuantidadeDeDiasDeAtraso()));
			contaDTO.setValorCorrigido(contaDTO.getValorOriginal().add(valorDaMulta).add(jurosProporcionais).setScale(2));			
		}
		
		return listaContaDTO;
	}
	
	@PostMapping("/")
	@ApiOperation("Salva uma conta a pagar")
	public Conta salvar(@RequestBody Conta conta)
	{
		return contaService.salvar(conta);
	}		
	
}

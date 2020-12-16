package br.com.deliver.it.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Object> salvar(@RequestBody @Valid Conta conta, BindingResult result)
	{
		StringBuilder mensagem = new StringBuilder();
		if(result.hasErrors())
		{
			List<FieldError> erros = result.getFieldErrors();
			for (FieldError erro : erros ) {
				mensagem.append(erro.getDefaultMessage());
			}
			return new ResponseEntity<>(mensagem.toString(),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(contaService.salvar(conta),HttpStatus.OK);	
	}		
	
}

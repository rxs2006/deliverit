package br.com.deliver.it.controller.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ContaDTO {	
	private String nome;
	private BigDecimal valorOriginal;
	private LocalDate dataDePagamento;
	private BigDecimal valorCorrigido;	
	
	@JsonIgnore
	private LocalDate dataDeVencimento;
	
	@Getter(AccessLevel.NONE)
	private Long quantidadeDeDiasDeAtraso;
	
	public Long getQuantidadeDeDiasDeAtraso()
	{
		return ChronoUnit.DAYS.between(dataDeVencimento, dataDePagamento);
	}	
}

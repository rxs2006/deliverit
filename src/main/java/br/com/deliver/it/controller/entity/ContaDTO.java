package br.com.deliver.it.controller.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ContaDTO {
	private String nome;
	private BigDecimal valorOriginal;
	private BigDecimal valorCorrigido;
	private Integer quantidadeDeDiasDeAtraso;
	private LocalDate dataDePagamento;
}

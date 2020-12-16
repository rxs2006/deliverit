package br.com.deliver.it.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden=true)
	private int id;	
	
	@NotBlank(message = "Você deve informar o nome")
	private String nome;
	
	@NotNull(message = "Você deve informar o valor original")
	private BigDecimal valorOriginal; 
	
	@NotNull(message = "Você deve informar a data de vencimento")
	private LocalDate dataDeVencimento;
	
	@NotNull(message = "Você deve informar a data de pagamento")
	private LocalDate dataDePagamento;
	
	public Conta(Integer id)
	{
		this.id = id;
	}
}

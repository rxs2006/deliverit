package br.com.deliver.it.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private int id;	
	private String nome;
	private Float valorOriginal; 
	@JsonIgnore
	private LocalDate dataDeVencimento;
	private LocalDate dataDePagamento;
	
	public Conta(Integer id)
	{
		this.id = id;
	}
}

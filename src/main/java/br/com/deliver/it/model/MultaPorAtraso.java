package br.com.deliver.it.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "multaporatraso")
public class MultaPorAtraso {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int id;	
	private Integer diasEmAtraso;
	private BigDecimal multa;
	private BigDecimal juros;	
	
	public MultaPorAtraso(Integer id)
	{
		this.id = id;
	}
}

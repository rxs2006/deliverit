package br.com.deliver.it.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "multaporatraso")
public class MultaPorAtraso {
	@Id
	@Column(name = "diasematraso")
	private Integer diasEmAtraso;
	private BigDecimal multa;
	private BigDecimal juros;	
}

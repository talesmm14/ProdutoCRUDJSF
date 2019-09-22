package br.unitins.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "pagamento")

public class Pagamento implements Serializable{
	private static final long serialVersionUID = 5967785059951516104L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name = "tipopagamento_id_fk")
	private TipoPagamento tipoPagamento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public TipoPagamento getTipoPagamento() {
		if (tipoPagamento == null)
			tipoPagamento = new TipoPagamento();
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}

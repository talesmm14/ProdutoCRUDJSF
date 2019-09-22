package br.unitins.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento implements Serializable{
	private static final long serialVersionUID = 4814674092598090579L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(max = 150)
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

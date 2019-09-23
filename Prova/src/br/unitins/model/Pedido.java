package br.unitins.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 9182213147289424436L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private Double valorTotal;
	
	@NotEmpty
	private LocalDate data;
	
	@OneToOne	
	@JoinColumn(name = "pagamento_id_fk")
	private Pagamento pagamento;
	
	@OneToOne
	@JoinColumn(name = "cliente_id_fk")
	private Cliente cliente;
	
	@OneToMany
	private List <Produto> produtos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		if (pagamento == null)
			pagamento = new Pagamento();
		this.pagamento = pagamento;
	}
	public Cliente getCliente() {
		if (cliente == null)
			cliente = new Cliente();
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = new ArrayList<>();
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}

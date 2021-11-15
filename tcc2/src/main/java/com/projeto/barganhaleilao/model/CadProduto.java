package com.projeto.barganhaleilao.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class CadProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@NotEmpty(message="Nome do produto � obrigat�rio.")
	@Size(max = 30, message = "Descri��o tem que ter no m�ximo 30 caracteres")
	private String produto;

	@NotNull(message="Pre�o � obrigat�rio.")
	@DecimalMin(value= "0.01", message = "Pre�o n�o pode ser menor que 0,01")
	@DecimalMax(value= "9999999.99", message = "Pre�o n�o pode ser maior que 9999999.99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco;

	@NotEmpty(message="Descri��o � obrigat�ria.")
	@Size(max = 60, message = "Descri��o tem que ter no m�ximo 60 caracteres")
	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusVenda status;
	
	
	private String caminho;

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadProduto other = (CadProduto) obj;
		return codigo == other.codigo;
	}

}

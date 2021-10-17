package br.com.dev.academia.domain.aluno;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco implements Serializable{

	@Column(name = "RUA", nullable = false)
	private String rua;

	@Column(name = "NUMERO", nullable = true)
	private Integer numero;

	@Column(name = "COMPLEMENTO", nullable = true)
	private String complemento;

	@Column(name = "CIDADE", nullable = false)
	private String cidade;

	@ManyToOne
	@JoinColumn(name = "ESTADO_ID", nullable = false)
	private Estado estado;

	@Column(name = "CEP", nullable = false)
	private String cep;

	public Endereco() {
		this.estado = new Estado();
	}

	public String getrua() {
		return rua;
	}

	public void setrua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, complemento, estado, numero, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estado, other.estado)
				&& Objects.equals(numero, other.numero) && Objects.equals(rua, other.rua);
	}

}

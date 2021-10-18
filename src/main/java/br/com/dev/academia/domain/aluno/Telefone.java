package br.com.dev.academia.domain.aluno;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Telefone implements Serializable {
	
	@Column(name = "DDD_CELULAR", nullable = false)
	private Integer dddCelular;

	@Column(name = "NUMERO_CELULAR", nullable = true)
	private Integer numeroCelular;

	@Column(name = "DDD_FIXO", nullable = false)
	private Integer dddFixo;

	@Column(name = "NUMERO_FIXO", nullable = true)
	private Integer numeroFixo;

	public Integer getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}

	public Integer getnumeroCelular() {
		return numeroCelular;
	}

	public void setnumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Integer getDddFixo() {
		return dddFixo;
	}

	public void setDddFixo(Integer dddFixo) {
		this.dddFixo = dddFixo;
	}

	public Integer getNumeroFixo() {
		return numeroFixo;
	}

	public void setNumeroFixo(Integer numeroFixo) {
		this.numeroFixo = numeroFixo;
	}

	@Override
	public String toString() {
		return "Telefone [dddCelular=" + dddCelular + ", numeroCelular=" + numeroCelular + ", dddFixo=" + dddFixo
				+ ", numeroFixo=" + numeroFixo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dddCelular, dddFixo, numeroCelular, numeroFixo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(dddCelular, other.dddCelular) && Objects.equals(dddFixo, other.dddFixo)
				&& Objects.equals(numeroCelular, other.numeroCelular) && Objects.equals(numeroFixo, other.numeroFixo);
	}

}

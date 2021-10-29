package br.com.dev.academia.domain.acesso;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dev.academia.domain.aluno.Aluno;

@Entity
@Table(name = "ENTRADAS_SAIDAS")
public class Acesso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ALUNO_ID", nullable = false)
	private Aluno aluno;

	@Column(name = "ENTRADA", nullable = false)
	private LocalDateTime entrada;

	@Column(name = "SAIDA", nullable = true)
	private LocalDateTime saida;

	public boolean isEntradasSaidasPreenchidas() {
		if (entrada != null & saida != null) {
			return true;
		}
		return false;
	}

	public TipoAcesso registrarAcesso() {
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		TipoAcesso tipodeAcesso;

		if (entrada == null) {
			entrada = dataHoraAtual;
			tipodeAcesso = TipoAcesso.ENTRADA;

		} else if (saida == null) {
			saida = dataHoraAtual;
			tipodeAcesso = TipoAcesso.SAIDA;

		} else {
			tipodeAcesso = null;
		}
		return tipodeAcesso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Acesso [id=" + id + ", aluno=" + aluno + ", entrada=" + entrada + ", saida=" + saida + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, entrada, id, saida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(entrada, other.entrada)
				&& Objects.equals(id, other.id) && Objects.equals(saida, other.saida);
	}

}

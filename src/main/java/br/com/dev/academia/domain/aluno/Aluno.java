package br.com.dev.academia.domain.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dev.academia.application.util.StringUtils;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, length = 8)
	private String matricula;

	@Column(name = "NOME", nullable = false, length = 64)
	private String nome;

	@Enumerated
	@Column(name = "SEXO", nullable = false)
	private Sexo sexo;

	@Column(name = "RG", nullable = false, length = 10)
	private Integer rg;

	@Column(name = "NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;

	@Enumerated
	@Column(name = "SITUACAO", nullable = false)
	private Situacao situacao;

	@Column(name = "EMAIL", nullable = true, length = 64)
	private String email;

	@Column(name = "ENDERECO", nullable = false, length = 64)
	@Embedded
	private Endereco endereco;

	@Column(name = "FELEFONE", nullable = false, length = 64)
	@Embedded
	private Telefone telefone;

	public Aluno() {
		this.endereco = new Endereco();
		this.telefone = new Telefone();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public enum Sexo {
		MASCULINO, FEMININO;
	}

	public enum Situacao {
		ATIVO, INATIVO, PENDENTE;
	}

	public void gerarMatricula(String maxMatricula) {
		Year year = Year.now();

		if (maxMatricula == null) {
			maxMatricula = year + StringUtils.leftZeros(0, 4);
		}

		int sequantial = Integer.parseInt(maxMatricula.substring(4));

		sequantial++;

		this.matricula = year + StringUtils.leftZeros(sequantial, 4);
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", sexo=" + sexo + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", situacao=" + situacao + ", email=" + email + ", endereco="
				+ endereco + ", telefone=" + telefone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, email, endereco, matricula, nome, rg, sexo, situacao, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(nome, other.nome) && Objects.equals(rg, other.rg) && sexo == other.sexo
				&& situacao == other.situacao && Objects.equals(telefone, other.telefone);
	}

}

package br.com.dev.academia.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.dev.academia.application.util.StringUtils;
import br.com.dev.academia.application.util.ValidationException;
import br.com.dev.academia.domain.acesso.Acesso;
import br.com.dev.academia.domain.acesso.AcessoRepository;
import br.com.dev.academia.domain.acesso.TipoAcesso;
import br.com.dev.academia.domain.aluno.Aluno;
import br.com.dev.academia.domain.aluno.AlunoRepository;

@Stateless
public class AcessoService {

	@EJB
	private AcessoRepository acessoRepository;

	@EJB
	private AlunoRepository alunoRepository;

	public TipoAcesso registrarAcesso(String matricula, Integer rg) {
		TipoAcesso acesso = null;
		Aluno alunoRegistro;

		if (StringUtils.isEmpty(matricula) && rg == null) {
			throw new ValidationException("É preciso informar a matricula ou o RG do Aluno");
		}

		if (StringUtils.isEmpty(matricula)) {
			alunoRegistro = alunoRepository.findByRg(rg);
		} else {
			alunoRegistro = alunoRepository.findByMatricula(matricula);
		}

		if (alunoRegistro == null) {
			throw new ValidationException("O Aluno não foi encotrado!\nVerifique os parametros de busca.");
		}

		Acesso acessoUltimo = acessoRepository.ultimoAcesso(alunoRegistro);

		if (acessoUltimo == null || acessoUltimo.isEntradasSaidasPreenchidas()) {
			acessoUltimo = new Acesso();
			acessoUltimo.setAluno(alunoRegistro);
			acesso = acessoUltimo.registrarAcesso();
			acessoRepository.store(acessoUltimo);
			
		}else {
			acesso = acessoUltimo.registrarAcesso();
		}

		return acesso;
	}

}

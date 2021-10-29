package br.com.dev.academia.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.dev.academia.application.util.StringUtils;
import br.com.dev.academia.application.util.ValidationException;
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
			acesso = TipoAcesso.ENTRADA;
		} else {
			alunoRegistro = alunoRepository.findByMatricula(matricula);
			acesso = TipoAcesso.ENTRADA;
		}
		
		if(alunoRegistro == null) {
			throw new ValidationException("O Aluno não foi encotrado!\nVerifique os parametros de busca.");
		}

		return acesso;
	}

}

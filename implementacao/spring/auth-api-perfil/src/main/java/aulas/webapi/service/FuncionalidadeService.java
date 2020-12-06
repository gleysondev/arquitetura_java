package aulas.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aulas.webapi.model.TipoOperacao;
import aulas.webapi.model.acesso.Funcionalidade;
import aulas.webapi.model.acesso.Permissao;
import aulas.webapi.repository.FuncionalidadeRepository;
import aulas.webapi.repository.PermissaoRepository;

@Service
public class FuncionalidadeService {
	@Autowired
	private FuncionalidadeRepository funcionalidadeRepository;
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Transactional
	public List<Permissao> insert(Funcionalidade entidade) {
		List<Permissao> permissoes = new ArrayList<Permissao>();
		funcionalidadeRepository.save(entidade);
		for(TipoOperacao tp:TipoOperacao.values()) {
			Permissao p = new Permissao();
			p.setAcao(tp.getNome());
			p.setFuncionalidade(entidade.getId());
			p.setId(entidade.getId() + "_"+tp.name());
			permissoes.add(p);
			permissaoRepository.save(p);
		}
		return permissoes;
	}
	public List<Funcionalidade> search(){
		return funcionalidadeRepository.findAll();
	}
}

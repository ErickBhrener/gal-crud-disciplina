package br.ufc.quixada.gal.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.ufc.quixada.gal.model.Disciplinas;
import br.ufc.quixada.gal.repository.DisciplinaRepository;

@Named
public class DisciplinaServiceImpl implements DisciplinaService{
	
	@Inject
	private DisciplinaRepository dr;
	
	public DisciplinaServiceImpl() {
	}

	@Transactional
	public void inserir(Disciplinas disciplina) {
		dr.save(disciplina);
	}
	@Transactional
	public Disciplinas pesquisar(String cod, String nome) {
		return dr.pesquisarDisciplina(cod, nome);
	}

}

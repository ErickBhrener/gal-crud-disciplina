package br.ufc.quixada.gal.service;

import br.ufc.quixada.gal.model.Disciplinas;

public interface DisciplinaService {
	public abstract void inserir(Disciplinas disciplina);
	public abstract Disciplinas pesquisar(String cod, String nome);
}

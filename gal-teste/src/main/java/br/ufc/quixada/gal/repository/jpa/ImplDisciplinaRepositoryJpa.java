package br.ufc.quixada.gal.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.quixada.gal.model.Disciplinas;
import br.ufc.quixada.gal.repository.DisciplinaRepository;

@Repository
public class ImplDisciplinaRepositoryJpa implements DisciplinaRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Disciplinas disciplina) {
			if(disciplina.getIdDisciplina() == null){
				em.persist(disciplina);			
			}else
				em.merge(disciplina);
	}
	
	public Disciplinas pesquisarDisciplina(String cod, String nome){
		try{
			return (Disciplinas)em.createQuery("from Disciplinas where cod_d =:cod", Disciplinas.class).setParameter("cod", cod).getSingleResult();
		}catch(NoResultException nre){
			
			return null;
		}
	}

}

package br.ufc.quixada.gal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@Table(name="disciplinas")
public class Disciplinas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_d")
	private Integer idDisciplina;
	
	@NotEmpty(message="Campo não pode ficar vazio")
	@Column(name="cod_d",nullable=false,unique=true)
	@Pattern(regexp="^[a-zA-Z0-9]+",message="Não pode possuir caracteres especiais")
	private String codDisciplina;
	
	@NotEmpty(message="Campo não pode ficar vazio")
	@Column(name="nome",nullable=false)
	@Pattern(regexp="[a-zA-Z\\sà-ùÀ-Ù]{0,}", message="Nome da disciplina não pode conter caracteres especiais")
	private String nomeDisciplina;

	public Disciplinas(String codDisciplina, String nomeDisciplina) {
		super();
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}

	public Disciplinas() {
		super();
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	
}

package br.ufc.quixada.gal.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.quixada.gal.model.Disciplinas;
import br.ufc.quixada.gal.service.DisciplinaService;


@Controller
//@RequestMapping("/")
public class DisciplinaController {
	
	@Inject
	private DisciplinaService ds;
	
	@RequestMapping("/")
		public String form() {
		return "index";
	}
	
	@RequestMapping("inserirDisciplina")
	public String inserir(Disciplinas disciplina) {
		ds.inserir(disciplina);
		return "disciplina-adicionada";
	}
	
}

package br.ufc.quixada.gal.web;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="inserirDisciplina",method = RequestMethod.POST)
	public String inserir(@Valid Disciplinas disciplina, BindingResult result) {
		if(result.hasErrors()) {
			return "index";
		}
		ds.inserir(disciplina);
		return "disciplina-adicionada";
	}
	
}

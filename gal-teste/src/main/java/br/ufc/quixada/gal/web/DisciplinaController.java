package br.ufc.quixada.gal.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
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
	public String inserir(@Valid Disciplinas disciplina, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("Erro");
			return "index";
		}
		if(ds.pesquisar(disciplina.getCodDisciplina(), disciplina.getNomeDisciplina())==null){
			ds.inserir(disciplina);
			session.setAttribute("message", "Disciplina inserida com sucesso");
		}else{
			session.setAttribute("message", "Esta disciplina já está cadastrada no banco");
			return "index";
		}
		return "disciplina-adicionada";
	}
	
}

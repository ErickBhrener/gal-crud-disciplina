package br.ufc.quixada.gal.web;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.gal.model.Disciplinas;
import br.ufc.quixada.gal.service.DisciplinaService;


@Controller
//@RequestMapping("/")
public class DisciplinaController {
	
	@Inject
	private DisciplinaService ds;
	
	@RequestMapping("/")
		public String form(final RedirectAttributes redirectAttributes) {
		return "index";
	}
	@RequestMapping("/disciplina-adicionada")
	public String confirm(){
		return "disciplina-adicionada";
	}
	@RequestMapping(value="inserirDisciplina",method = RequestMethod.POST)
	public String inserir(@Valid Disciplinas disciplina, BindingResult result, final RedirectAttributes redirectAttributes) {
		if(disciplina.getCodDisciplina()==null || disciplina.getCodDisciplina().equals("")) {
			System.out.println("Erro");
			return "index";
		}
		if(disciplina.getNomeDisciplina()==null || disciplina.getNomeDisciplina().equals("")){
			System.out.println("Erro");
			return "index";
		}
		if(result.hasErrors())
			return "index";
		if(ds.pesquisar(disciplina.getCodDisciplina(), disciplina.getNomeDisciplina())==null){
			ds.inserir(disciplina);
			System.out.println("Disciplina adicionada com sucesso");
			return "redirect:disciplina-adicionada";
		}else{
			redirectAttributes.addFlashAttribute("message", "Disciplina não pode ser adicionada pois já existe semelhante registrada");
			return "redirect:/";
		}
		
	}
	
}

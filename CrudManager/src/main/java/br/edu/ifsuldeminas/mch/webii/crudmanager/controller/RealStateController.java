package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.RealStateRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.RealState;


@Controller
public class RealStateController {
	
	@Autowired
	private RealStateRepository realStateRepository;
	
	@GetMapping("/imoveis")
	public String imoveis (Model model) {
		
		
		List<RealState> rs = realStateRepository.findAll();
		model.addAttribute("imoveis", rs);
		return "imoveis";
	}
	
	@GetMapping("/imoveis/form")
	public String imovelForm(@ModelAttribute("imoveis") RealState rs) {
		
		return "imovel_form";
	}
	
	@PostMapping("/imoveis/new")
	public String imovelNew(@ModelAttribute("imoveis") RealState rs) {
		
		realStateRepository.save(rs);
		
		return "redirect:/imoveis";
	}
	
	@GetMapping("/imoveis/update/{id}")
	public String imovelUpdate(@PathVariable("id")Integer id, Model model) {
		
		Optional<RealState> optRs = realStateRepository.findById(id);
		if(optRs.isPresent()) {
			//gerar erro
		}
		
		RealState rs = optRs.get();
		
		model.addAttribute("imoveis", rs);
		
		return "imovel_form";
	}
	
	@GetMapping("/imoveis/delete/{id}")
	public String imovelDelete(@PathVariable("id")Integer id) {
		
		Optional<RealState> optRs = realStateRepository.findById(id);
		if(optRs.isPresent()) {
			//gerar erro
		}
		
		RealState rs = optRs.get();
		
		realStateRepository.delete(rs);
		
		return "redirect:/imoveis";
		
		
	}
	
}
	


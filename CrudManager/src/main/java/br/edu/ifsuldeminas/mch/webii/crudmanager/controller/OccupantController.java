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
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.OccupantRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Occupant;


@Controller
public class OccupantController {
	
	@Autowired
	private OccupantRepository occupantRepository;
	
	@GetMapping("/occupants")
	public String inquilinos(Model model) {
		
		
		List<Occupant> occupants = occupantRepository.findAll();
		model.addAttribute("occupants", occupants);
		return "index";
	}
	
	@GetMapping("/occupants/form")
	public String occupantForm(@ModelAttribute("occupant") Occupant occupant) {
		
		return "occupant_form";
	}
	
	@PostMapping("/occupants/new")
	public String occupantNew(@ModelAttribute("occupant") Occupant occupant) {
		
		occupantRepository.save(occupant);
		
		return "redirect:/occupants";
	}
	
	@GetMapping("/occupants/update/{id}")
	public String occupantUpdate(@PathVariable("id")Integer id, Model model) {
		
		Optional<Occupant> optOccupant = occupantRepository.findById(id);
		if(optOccupant.isPresent()) {
			//gerar erro
		}
		
		Occupant occupant = optOccupant.get();
		
		model.addAttribute("occupant", occupant);
		
		return "occupant_form";
	}
	
	@GetMapping("/occupants/delete/{id}")
	public String occupantDelete(@PathVariable("id")Integer id) {
		
		Optional<Occupant> optOccupant = occupantRepository.findById(id);
		if(optOccupant.isPresent()) {
			//gerar erro
		}
		
		Occupant occupant = optOccupant.get();
		
		occupantRepository.delete(occupant);
		
		return "redirect:/occupants";
		
		
	}
	
}
	


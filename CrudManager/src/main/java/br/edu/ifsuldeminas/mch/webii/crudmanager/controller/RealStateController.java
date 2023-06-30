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

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.AddressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.OccupantRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.RealStateRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Address;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Occupant;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.RealState;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;


@Controller
public class RealStateController {
	
	@Autowired
	private RealStateRepository realStateRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OccupantRepository occupantRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/imoveis")
	public String imoveis (Model model) {
		
		
		List<RealState> rs = realStateRepository.findAll();
		model.addAttribute("imoveis", rs);
		return "listar_imoveis";
	}
	
	
	@PostMapping("/imoveis/new")
	public String imovelNew(@ModelAttribute("imoveis") RealState rs) {
		
		realStateRepository.save(rs);
		
		return "redirect:/imoveis";
	}
	
	@GetMapping("/imoveis/update/{id}")
	public String imovelUpdate(@PathVariable("id")Integer id, Model model) {
		

	    Optional<RealState> optRs = realStateRepository.findById(id);
	    if (optRs.isPresent()) {
	        RealState rs = optRs.get();
	        model.addAttribute("imoveis", rs);
	    } else {
	        // Tratar o caso em que o RealState não é encontrado
	    }

	    List<Address> addresses = addressRepository.findAll();
	    model.addAttribute("addresses", addresses);

	    List<Occupant> occupants = occupantRepository.findAll();
	    model.addAttribute("occupants", occupants);

	    List<User> users = userRepository.findAll();
	    model.addAttribute("users", users);

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
	
	
	@GetMapping("/imoveis/form")
	public String imovelForm(@ModelAttribute("imoveis") RealState rs, Model model) {
	    List<User> users = userRepository.findAll();
	    List<Occupant> occupants = occupantRepository.findAll();
	    List<Address> addresses = addressRepository.findAll();

	    model.addAttribute("users", users);
	    model.addAttribute("occupants", occupants);
	    model.addAttribute("addresses", addresses);

	    return "imovel_form";
	}


	
	
}
	


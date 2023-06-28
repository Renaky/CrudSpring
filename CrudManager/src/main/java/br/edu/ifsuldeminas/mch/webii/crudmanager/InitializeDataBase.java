package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.controller.OccupantController;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.AddressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.OccupantRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.RealStateRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OccupantRepository occupantRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RealStateRepository rsRepo;
	
	@Override
	public void run(String... args) throws Exception {
		User emerson = new User();
		emerson.setName("Emerson");
		emerson.setEmail("emerson@gmail.com");
		emerson.setGender("M");
		
		User luiza = new User();
		luiza.setName("Luiza");
		luiza.setEmail("luiza@gmail.com");
		luiza.setGender("F");
		
		User renaki = new User();
		renaki.setName("Renaki");
		renaki.setEmail("renaki@gmail.com");
		renaki.setGender("M");
		
		userRepository.save(emerson);
		userRepository.save(luiza);
		userRepository.save(renaki);
		
		userRepository.flush();
		
		//criando inquilino
		Occupant joao = new Occupant();
		joao.setName("Joao Lucas");
		joao.setGender("M");
		joao.setEmail("Joaonaopadre@gmail.com");
		joao.setTel("3532831754");
		
		
		Occupant carlos = new Occupant();
		carlos.setName("Carlos Calil");
		carlos.setGender("M");
		carlos.setEmail("carlinfogueteiro@gmail.com");
		carlos.setTel("3456789121");
		
		
		occupantRepository.save(joao);
		occupantRepository.save(carlos);
		
		occupantRepository.flush();
		
		Address ruab = new Address();
		ruab.setNumber(178);
		ruab.setPlace("Rua Barão Vermelho");
		ruab.setZipCode("3478-014");
		
		addressRepository.save(ruab);
		addressRepository.flush();
		
		//imobiliaria criando casa
		RealState rs1 = new RealState();
		rs1.setSize(140);
		rs1.setColor("Azul céu");
		rs1.setOccupant(joao);
		rs1.setOwner(renaki);
		rs1.setAddress(ruab);
		
		rsRepo.save(rs1);
		rsRepo.flush();
     }
	
}

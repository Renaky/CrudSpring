package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="usuarios")
public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@NotBlank(message = "Nome não pode ser vazio")
		private String name;
		
		@NotBlank(message = "Email não pode ser vazio")
		@Email(message = "Endereço de Email Invalido")
		private String email;
		
		@NotBlank(message = "Gênero não pode ser vazio")
		private String gender;
		
	
		
	public User() {};
	
	public User(Integer id)
	{  
		this.id = id;
		setName("");
		setEmail("");
		setGender("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

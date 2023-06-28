package br.edu.ifsuldeminas.mch.webii.crudmanager.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="imoveis")

public class RealState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Metragem não pode ser vazia")
	@Min(value = 0, message = "Metragem deve ser maior ou igual a 0")
	private Double size;
	
	@NotBlank(message = "Cor não pode ser vazia")
	private String color;
	
	@ManyToOne
	@Valid
	private Occupant occupant;
	
	@ManyToOne
	@Valid
	private User owner;
	
	@OneToOne
	@Valid
	private Address address;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Occupant getOccupant() {
		return occupant;
	}

	public void setOccupant(Occupant occupant) {
		this.occupant = occupant;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}

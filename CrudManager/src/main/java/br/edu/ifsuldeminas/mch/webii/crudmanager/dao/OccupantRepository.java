package br.edu.ifsuldeminas.mch.webii.crudmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Occupant;

public interface OccupantRepository extends JpaRepository<Occupant, Integer> {

}

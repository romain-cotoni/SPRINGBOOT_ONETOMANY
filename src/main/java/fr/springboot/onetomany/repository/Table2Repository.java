package fr.springboot.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.springboot.onetomany.model.Table2Model;

@Repository
public interface Table2Repository extends JpaRepository<Table2Model,Integer> {

}

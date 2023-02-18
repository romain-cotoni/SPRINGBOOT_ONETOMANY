package fr.springboot.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.springboot.onetomany.model.Table1Model;


@Repository
public interface Table1Repository extends JpaRepository<Table1Model,Integer> {

	
}

package fr.springboot.onetomany.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.springboot.onetomany.model.Table1Model;
import fr.springboot.onetomany.model.Table2Model;
import fr.springboot.onetomany.repository.Table1Repository;
import fr.springboot.onetomany.repository.Table2Repository;

@Service
public class Table1Service {

	@Autowired
	Table1Repository table1Repository;
	
	@Autowired
	Table2Repository table2Repository;

	public Iterable<Table1Model> getAllTable1Models() {
		return table1Repository.findAll();
	}

	public Table1Model getTable1ModelById(Integer id) throws Exception {
		try {
			Optional<Table1Model> optional = table1Repository.findById(id);
			if (optional.isPresent())
				return optional.get();
			else
				return null;
		} catch (Exception exception) {
			throw new Exception("Error in Table1Service - getTable1ModelById() - " + exception.getMessage());
		}
	}

	public Table1Model createTable1Model(Table1Model table1Model) throws Exception {
		try {			
			return table1Repository.save(table1Model);
		} catch (Exception exception) {
			throw new Exception("Error in Table1Service - createTable1Model() - " + exception.getMessage());
		}
	}

	public Table1Model addTable2ToTable1(Integer id1, Integer id2) {
		Table1Model table1 = table1Repository.findById(id1).get();
		Table2Model table2 = table2Repository.findById(id2).get();
		table1.addTable2Model(table2);//You need to update both sides of the association.
		return table1Repository.save(table1);
	}
	
	public void deleteTable1Model(Integer id) throws Exception {
		table1Repository.deleteById(id);
	}


}

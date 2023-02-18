package fr.springboot.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.springboot.onetomany.model.Table2Model;
import fr.springboot.onetomany.repository.Table2Repository;

@Service
public class Table2Service {

	@Autowired
	Table2Repository table2Repository;
	
	public Iterable<Table2Model> getAllTable2Models() {
		return table2Repository.findAll();
	}

	public Table2Model getTable2ModelById(Integer id) throws Exception {
		return table2Repository.findById(id).orElseThrow();
	}

	public Table2Model createTable2Model(Table2Model table2Model) {
		return table2Repository.save(table2Model);
	}

	public void deleteTable2Model(Integer id) throws Exception {
		table2Repository.deleteById(id);
	}
}

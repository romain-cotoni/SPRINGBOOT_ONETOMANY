package fr.springboot.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.springboot.onetomany.model.Table2Model;
import fr.springboot.onetomany.service.Table2Service;

@RestController
@RequestMapping("/api/table2")
public class Table2Controller {

	@Autowired
	Table2Service table2Service;
	
	@GetMapping("")
	public Iterable<Table2Model> getAlltable2Models() throws Exception {
		return table2Service.getAllTable2Models();
	}
	
	@GetMapping("/{id}")
	public Table2Model gettable2ModelById(@PathVariable Integer id) throws Exception {
		return table2Service.getTable2ModelById(id);
	}
	
	@PostMapping("")
	public Table2Model createTable2Model(@RequestBody Table2Model table2Model) {
		return table2Service.createTable2Model(table2Model);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTable2Model(@PathVariable Integer id) throws Exception {
		table2Service.deleteTable2Model(id);
	}
}


package fr.springboot.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.springboot.onetomany.model.Table1Model;
import fr.springboot.onetomany.service.Table1Service;

@RestController
@RequestMapping("/api/table1")
public class Table1Controller {
	
	@Autowired
	Table1Service table1Service;
	
	@GetMapping("")
	public Iterable<Table1Model> getAllTable1Models() throws Exception {
		return table1Service.getAllTable1Models();
	}
	
	@GetMapping("/{id}")
	public Table1Model getTable1ModelById(@PathVariable Integer id) throws Exception {
		return table1Service.getTable1ModelById(id);
	}
	
	@PostMapping("")
	public Table1Model createTable1Model(@RequestBody Table1Model table1Model) throws Exception {
		return table1Service.createTable1Model(table1Model);
	}
	
	@PostMapping("/{id1}/{id2}")
	public Table1Model addTable2ToTable1(@PathVariable Integer id1,@PathVariable Integer id2) throws Exception {
		return table1Service.addTable2ToTable1(id1,id2);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTable1Model(@PathVariable Integer id) throws Exception {
		table1Service.deleteTable1Model(id);
	}

}

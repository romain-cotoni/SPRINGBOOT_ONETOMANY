package fr.springboot.onetomany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "table1")
public class Table1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tbl1")
	private int id;

	@Column(name = "label_tbl1", length = 50)
	private String label;

	@Column(name = "level_tbl1")
	private Integer level;

	//unidirectional
//	@OneToMany
//	@JoinColumn(name = "id_tbl1") //To prevent third table for association and use column for association instead
//	private Set<Table2Model> table2Models;
	
	//bidirectional
    @OneToMany(mappedBy="table1Model", cascade = CascadeType.ALL) //add mappedBy for bidirectional and mark it as the inverse side
    private Set<Table2Model> table2Models;

	public Table1Model() {
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Set<Table2Model> getTable2Models() {
		return table2Models;
	}

	public void setTable2Models(Set<Table2Model> table2Models) {
		this.table2Models = table2Models;
	}
	
	/**
	 * Whenever you have a bidirectional association
	 * you need to update both sides 
	 * using addChild and removeChild methods in the parent entity
	 */
	public void addTable2Model(Table2Model table2Model) {
        table2Models.add(table2Model);
        table2Model.setTable1Model(this);
    }
 
    public void removeTable2Model(Table2Model table2Model) {
    	table2Models.remove(table2Model);
    	table2Model.setTable1Model(null);
    }

}

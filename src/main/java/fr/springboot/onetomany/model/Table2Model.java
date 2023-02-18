package fr.springboot.onetomany.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "table2")
public class Table2Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tbl2")
	private int id;
	
	@Column(name="label_tbl2", length=50)
	private String label;

	@Column(name="level_tbl2")
	private Integer level;
	
	//bidirectional
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="id_tbl1")
	private Table1Model table1Model;
	
	public Table2Model() {
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
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	//bidirectional
	public Table1Model getTable1Model() {
		return table1Model;
	}

	public void setTable1Model(Table1Model table1Model) {
		this.table1Model = table1Model;
	}

}

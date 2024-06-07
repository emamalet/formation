package fr.em.training.backend.pokemon.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "type_1", nullable = false)
	private String type1;

	@Column(name = "type_2", nullable = true)
	private String type2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

}

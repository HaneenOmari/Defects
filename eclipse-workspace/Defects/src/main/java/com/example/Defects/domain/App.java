package com.example.Defects.domain;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class App {
	public App() {
		
	}
	
	public App(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String name,type;
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
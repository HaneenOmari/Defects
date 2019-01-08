package com.example.CarApplication.domain;


import java.util.HashSet;
import java.util.Set;
//hhhhghddhh
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
@Entity
public class Trip {
	
	public Trip() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String  name,place;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Trip( String name, String place) {
		super();
		
		this.name = name;
		this.place = place;
	}
	
	
	
	public Trip(String place, Set<Car> cars) {
		super();
		this.place = place;
		this.cars = cars;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "car_trip", joinColumns = { @JoinColumn(name =
     "tripid") }, inverseJoinColumns = { @JoinColumn(name = "id") }) 
    private Set<Car> cars = new HashSet<Car>(0); 

    public Set<Car> getCars() {
      return cars;
    }

    public void setCars(Set<Car> cars) {
      this.cars = cars;
    }


	
	
}

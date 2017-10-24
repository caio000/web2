package models;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@Table
public class Address implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	private String publicPlace;
	private String neighborhood;
	private int number;
	
	@OneToOne(mappedBy="address", targetEntity=User.class, fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private User user;
	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getPublicPlace() {
		return this.publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}   
	public String getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}   
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
   
}

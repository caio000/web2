package models;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicle
 *
 */
@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String type;
	private static final long serialVersionUID = 1L;

	public Vehicle() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}

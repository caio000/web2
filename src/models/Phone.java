package models;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Phone
 *
 */
@Entity

public class Phone implements Serializable {

	   
	@Id
	private long id;
	
	@Column
	private String number;
	private static final long serialVersionUID = 1L;

	public Phone() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
   
}

package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Motorcycle
 *
 */
@Entity
@Table
public class Motorcycle extends Vehicle implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Motorcycle() {}
   
}

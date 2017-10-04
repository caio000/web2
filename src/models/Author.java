package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Author
 *
 */
@Entity
@Table
public class Author implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=100)
	private String name;
	
	@Column(nullable=true)
	private int age;

	@OneToMany(mappedBy="author", targetEntity=Book.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Book> books = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;

	//=========================================================================
	public Author(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Author(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Author () {}
	
	//=========================================================================
	
	
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
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void add (Book book) {
		this.books.add(book);
	}
   
}

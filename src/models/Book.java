package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Book
 * @author Caio de Freitas
 * @since 2017/10/03
 */
@Entity
@Table
public class Book implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=100, nullable=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="idAuthor")
	private Author author;
	
	@ManyToMany
	@JoinTable(
			joinColumns= {@JoinColumn(name="idBook")},
			inverseJoinColumns = {@JoinColumn(name="idCategory")}
	)
	private List<Category> categories;

	
	//===========================================================================
	public Book (long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Book (String name) {
		this.name = name;
	}
	public Book() {}
	
	//===========================================================================

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
   
}

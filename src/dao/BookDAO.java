package dao;

import java.util.List;

import models.Book;

public class BookDAO extends DAO<Book> {

	@Override
	public List<Book> getAll() {
		return entityManager.createQuery("FROM Book").getResultList();
	}

	@Override
	public Book getById(long id) {
		return this.entityManager.find(Book.class, id);
	}

}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<E> {
	
	protected EntityManager entityManager;
	
	//========================================================================
	
	public DAO() {
		this.entityManager = getEntityManager();
	}
	
	//========================================================================
	
	public EntityManager getEntityManager () {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("testejsp");
		
		if (entityManager == null) entityManager = factory.createEntityManager();
		
		return entityManager;
	}
	
	public boolean persist (E object) {
		boolean result = true;
		
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(object);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
			result = false;
		}
		
		return result;
	}

	public abstract E getById (long id);
	
	public boolean delete(E object) {
		boolean result = true;
		
		try {
			this.getEntityManager();
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(object);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	public abstract List<E> getAll();
	
}

package kekdao;

import java.util.List;

import org.hibernate.Session;

import kek.HibernateUtil;

public class GenericDaoImpl <T> implements GenericDao <T> {

	private Class<T> type;
	
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public int create(T newObject) {
		Session session = null;
		int temp = 0;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			temp = (int) session.save(newObject);
			session.getTransaction().commit();
			
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getById(int id) {
		Session session = null;
		T result = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			result = (T) session.get(type, id);
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
	  			session.close();
		}
	}
	
	@Override
	public void update(T object) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	
	@Override
	public void delete(T object) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		Session session = null;
		List<T> result = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			result =  (List<T>) session.createCriteria(type).list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}

package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.Theater;
import kek.Hall;
import kek.HibernateUtil;

public class TheaterDaoImpl extends GenericDaoImpl<Theater> implements TheaterDao{

	public TheaterDaoImpl(Class<Theater> type) {
		super(type);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getByName(String name) {
		Session session = null;
		List<Theater> result = new ArrayList<Theater>();
		if (name == null || name.equals("")) {
			result = getAll();
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select c from Theater c where c.name like :na");
			query.setString("na", name);
			result = query.list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hall> getHalls(Theater th) {
		Session session = null;
		List<Hall> result = new ArrayList<Hall>();
		if (th == null)
			return result;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select h from Hall h where h.theater = :id");
			query.setInteger("id", th.getTheater_id());
			result = query.list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}

package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.HibernateUtil;
import kek.Worker;

public class WorkerDaoImpl extends GenericDaoImpl<Worker> implements WorkerDao{

	public WorkerDaoImpl(Class<Worker> type) {
		super(type);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Worker> getByName(String name, String last_name) {
		Session session = null;
		List<Worker> result = new ArrayList<Worker>();
		if (last_name == null || last_name.equals("")) {
			result = getAll();
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			if (name == null || name.equals("")) {
				Query query = session.createQuery("select c from Worker c where c.last_name like :la");
				query.setString("la", last_name);
				result = query.list();
			} else {
				Query query = session.createQuery("select c from Worker c where c.name like :na AND c.last_name like :la");
				query.setString("na", name);
				query.setString("la", last_name);
				result = query.list();
			}
			
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

}

package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.Scenario;
import kek.HibernateUtil;

public class ScenarioDaoImpl extends GenericDaoImpl<Scenario> implements ScenarioDao{

	public ScenarioDaoImpl(Class<Scenario> type) {
		super(type);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Scenario> getByParam(String author_name, String name) {
		Session session = null;
		List<Scenario> result = new ArrayList<Scenario>();
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = null;
			if (author_name == null && name == null) {
				result = getAll();
			} else if (author_name != null && name != null) {
				query = session.createQuery("select c from Scenario c where c.source_name like :n AND c.author like :a");
				query.setString("n", name);
				query.setString("a", author_name);
				result = query.list();
			} else if (author_name != null) {
				query = session.createQuery("select c from Scenario c where c.author like :a");
				query.setString("a", author_name);
				result = query.list();
			} else if (name != null) {
				query = session.createQuery("select c from Scenario c where c.source_name like :n");
				query.setString("n", name);
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

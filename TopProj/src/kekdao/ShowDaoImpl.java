package kekdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.Scenario;
import kek.Shows;
import kek.Theater;
import kek.HibernateUtil;

public class ShowDaoImpl extends GenericDaoImpl<Shows> implements ShowDao {

	public ShowDaoImpl(Class<Shows> type) {
		super(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shows> getByScTh(Scenario scen, Theater th) {
		Session session = null;
		List<Shows> result = null;
		if (scen == null && th == null) {
			result = getAll();
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = null;
			if(th == null) {
				query = session.createQuery("select s from Shows s where s.scenario = :sc");
				query.setInteger("sc", scen.getScenario_id());
			}
			if (scen == null) {
				query = session.createQuery("select s from Shows s join s.hall h where h.theater = :id");
				query.setInteger("id", th.getTheater_id());
			}
			if (scen != null && th != null) {
				query = session.createQuery("select s from Shows s left join s.hall h "
						+ "where s.scenario = :sc and h.theater = :id");
				query.setInteger("sc", scen.getScenario_id());
				query.setInteger("id", th.getTheater_id());
			}
			result = query.list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	
	@Override
	public Theater getShowsTheater(Shows show) {
		Session session = null;
		Theater result = new Theater();
		if (show == null)
			return result;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select th from Shows s join s.hall h join h.theater as th where s.show_id = :id");
			query.setInteger("id", show.getShow_id());
			if (query.list().size() > 0)
				result = (Theater) query.list().get(0);
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	
}

package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.Place_for_sell;
import kek.Shows;
import kek.HibernateUtil;

public class Place_for_sellDaoImpl extends GenericDaoImpl<Place_for_sell> implements Place_for_sellDao{

	public Place_for_sellDaoImpl(Class<Place_for_sell> type) {
		super(type);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Place_for_sell> getByShow (Shows show) {
		Session session = null;
		List<Place_for_sell> result = new ArrayList<Place_for_sell>();
		if (show == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select p from Place_for_sell p where p.show = :id");
			query.setInteger("id", show.getShow_id());
			result = query.list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	
	
}

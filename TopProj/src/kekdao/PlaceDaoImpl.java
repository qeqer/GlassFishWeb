package kekdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.Place;
import kek.HibernateUtil;

public class PlaceDaoImpl extends GenericDaoImpl<Place> implements PlaceDao{

	public PlaceDaoImpl(Class<Place> type) {
		super(type);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Place> getByParam(int hall_id, int row, int num) {
		Session session = null;
		List<Place> result = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = null;
			if (row == 0 && num == 0) {
				query = session.createQuery("select p from Place p where p.hall_id = :hi")
						.setInteger("hi", hall_id);
			} else {
				query = session.createQuery("select p from Place p where p.hall_id = :hi AND p.row_num = :r AND p.num = :n")
						.setInteger("hi", hall_id)
						.setInteger("r", row)
						.setInteger("n", num);
			}
			
			if (!query.list().isEmpty())
				result = query.list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}

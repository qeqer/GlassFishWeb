package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.Booking;
import kek.Client;
import kek.HibernateUtil;

public class BookingDaoImpl extends GenericDaoImpl<Booking> implements BookingDao{
	
	public BookingDaoImpl(Class<Booking> type) {
		super(type);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getByClient(Client client) {
		Session session = null;
		List<Booking> result = new ArrayList<Booking>();
		if (client == null) {
			result = getAll(); 
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select b from Booking b where b.client = :id");
			query.setInteger("id", client.getClient_id());
			result = query.list();
			
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}

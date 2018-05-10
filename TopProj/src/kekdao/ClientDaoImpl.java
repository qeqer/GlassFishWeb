package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kekdao.ClientDao;
import kekdao.GenericDaoImpl;
import kek.Client;
import kek.HibernateUtil;


public class ClientDaoImpl extends GenericDaoImpl<Client>  implements ClientDao{
	public ClientDaoImpl(Class<Client> type) {
		super(type);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getByNameLast(String name, String last_name) {
		Session session = null;
		List<Client> result = new ArrayList<Client>();
		if (last_name == null)
			return result;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			if (name == null) {
				Query query = session.createQuery("select c from Client c where c.last_name like :la");
				query.setString("la", last_name);
				result = query.list();
			} else {
				Query query = session.createQuery("select c from Client c where c.name like :na AND c.last_name like :la");
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

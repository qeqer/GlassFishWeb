package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.HibernateUtil;
import kek.Shows;
import kek.Worker;
import kek.Worker_in_show;

public class Worker_in_showDaoImpl extends GenericDaoImpl<Worker_in_show> implements Worker_in_showDao{

	public Worker_in_showDaoImpl(Class<Worker_in_show> type) {
		super(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shows> getByWorker(Worker worker) {
		Session session = null;
		List<Shows> result = new ArrayList<Shows>();
		if (worker == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh.show_id from Worker_in_show wsh where wsh.worker_id = :id");
			query.setInteger("id", worker.getWorker_id());
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
	public List<Worker> getByShow(Shows show) {
		Session session = null;
		List<Worker> result = new ArrayList<Worker>();
		if (show == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh.worker_id from Worker_in_show wsh where wsh.show_id = :id");
			query.setInteger("id", show.getShow_id());
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
	public List<Worker_in_show> getByWorkerI(Worker worker) {
		Session session = null;
		List<Worker_in_show> result = new ArrayList<Worker_in_show>();
		if (worker == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh from Worker_in_show wsh where wsh.worker_id = :id");
			query.setInteger("id", worker.getWorker_id());
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
	public List<Worker_in_show> getByShowI(Shows show) {
		Session session = null;
		List<Worker_in_show> result = new ArrayList<Worker_in_show>();
		if (show == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh from Worker_in_show wsh where wsh.show_id = :id");
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

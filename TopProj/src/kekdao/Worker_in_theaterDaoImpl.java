package kekdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import kek.HibernateUtil;
import kek.Theater;
import kek.Worker;
import kek.Worker_in_theater;

public class Worker_in_theaterDaoImpl extends GenericDaoImpl<Worker_in_theater> implements Worker_in_theaterDao{

	public Worker_in_theaterDaoImpl(Class<Worker_in_theater> type) {
		super(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getByWorker(Worker worker) {
		Session session = null;
		List<Theater> result = new ArrayList<Theater>();
		if (worker == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh.theater_id from Worker_in_theater wsh"
					+ " where wsh.worker_id = :id");
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
	public List<Worker> getByTheater(Theater theater) {
		Session session = null;
		List<Worker> result = new ArrayList<Worker>();
		if (theater == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh.worker_id from Worker_in_theater wsh"
					+ " where wsh.theater_id = :id");
			query.setInteger("id", theater.getTheater_id());
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
	public List<Worker_in_theater> getByTheaterI(Theater theater) {
		Session session = null;
		List<Worker_in_theater> result = new ArrayList<Worker_in_theater>();
		if (theater == null) {
			return result;
		}
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select wsh from Worker_in_theater wsh"
					+ " where wsh.theater_id = :id");
			query.setInteger("id", theater.getTheater_id());
			result = query.list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}

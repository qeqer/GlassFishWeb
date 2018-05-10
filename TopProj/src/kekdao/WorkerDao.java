package kekdao;

import java.util.List;

import kek.Worker;

public interface WorkerDao extends GenericDao<Worker>{
	List<Worker> getByName(String name, String last_name);
}

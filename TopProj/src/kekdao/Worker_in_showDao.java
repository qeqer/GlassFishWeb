package kekdao;

import java.util.List;

import kek.Shows;
import kek.Worker;
import kek.Worker_in_show;

public interface Worker_in_showDao extends GenericDao<Worker_in_show>{
	List<Shows> getByWorker(Worker worker);
	List<Worker> getByShow(Shows show);
	List<Worker_in_show> getByWorkerI(Worker worker);
	List<Worker_in_show> getByShowI(Shows show);
}

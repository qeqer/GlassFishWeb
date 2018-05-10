package kekdao;

import java.util.List;

import kek.Theater;
import kek.Worker;
import kek.Worker_in_theater;

public interface Worker_in_theaterDao extends GenericDao<Worker_in_theater>{
	List<Theater> getByWorker(Worker worker);
	List<Worker> getByTheater(Theater theater);
	List<Worker_in_theater> getByTheaterI(Theater theater);
}

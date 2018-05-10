package kekdao;

import java.util.List;
import kek.Scenario;
import kek.Shows;
import kek.Theater;

public interface ShowDao extends GenericDao<Shows>{
	List<Shows> getByScTh(Scenario scen, Theater th);
	Theater getShowsTheater(Shows show);
}

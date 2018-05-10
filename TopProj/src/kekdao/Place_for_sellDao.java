package kekdao;

import java.util.List;
import kek.Place_for_sell;
import kek.Shows;

public interface Place_for_sellDao extends GenericDao<Place_for_sell>{
	List<Place_for_sell> getByShow (Shows show); //get all places for show
}

package kekdao;

import java.util.List;

import kek.Place;

public interface PlaceDao extends GenericDao<Place>{
	List<Place> getByParam(int hall_id, int row, int num);
}

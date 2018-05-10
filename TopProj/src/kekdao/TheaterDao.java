package kekdao;

import java.util.List;

import kek.*;

public interface TheaterDao extends GenericDao<Theater>{
	List<Theater> getByName(String name);
	List<Hall> getHalls(Theater th);
}

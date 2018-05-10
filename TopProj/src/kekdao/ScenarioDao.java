package kekdao;

import java.util.List;
import kek.Scenario;

public interface ScenarioDao extends GenericDao<Scenario>{
	List<Scenario> getByParam(String author_name, String name);
	
}

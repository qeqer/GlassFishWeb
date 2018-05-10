package kekdao;

import java.util.List;

import kek.Client;

public interface ClientDao extends GenericDao<Client>{
	List<Client> getByNameLast(String name, String last_name);
}

package kekdao;

import kek.Booking;
import kek.Client;
import java.util.List;

public interface BookingDao extends GenericDao<Booking>{
	List<Booking> getByClient(Client client);
}

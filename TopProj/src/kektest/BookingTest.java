package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import kek.*;
import kekdao.*;

public class BookingTest extends Assert{
	private BookingDao bD = Factory.getInstance().getBookingDao();
	private ClientDao cD = Factory.getInstance().getClientDao();
	private Place_for_sellDao psD = Factory.getInstance().getPlace_for_sellDao();
	
	@Test
	public void getByShClTest() {
		Client temp1 = cD.getById(1);
		List<Booking> temp2 = bD.getByClient(temp1);
		assertTrue(temp2.size() == 3);
		temp2 = bD.getByClient(null);
	}
	
	@Test
	public void addBookTest() {
		Booking temp = new Booking();
		Client client = cD.getById(1);
		Place_for_sell ps = psD.getById(4);
		
		temp.setClient(client);
		temp.setPlace(ps);
		bD.create(temp);
		
		
		List<Booking> test = bD.getAll();
		for (Booking t : test) {
			System.out.println(t.getId());
		}
		bD.delete(temp);
	}
	
}

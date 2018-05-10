package kektest;

import org.testng.annotations.Test;

import java.util.List;

import org.testng.Assert;

import kek.*;
import kekdao.*;

public class Worker_in_TheaterTest extends Assert{
	private Worker_in_theaterDao wtD = Factory.getInstance().getWorker_in_theaterDao();
	private TheaterDao tD = Factory.getInstance().getTheaterDao();
	@Test
	public void getByTheaterTest() {
		List<Worker_in_theater> wt = wtD.getAll();
		assertNotNull(wt);
		List<Theater> t = tD.getAll();
		assertNotNull(t);
		for (Theater the : t) {
			List<Worker>temp1 = wtD.getByTheater(the);
			List<Theater>temp2 = wtD.getByWorker(temp1.get(0));
			System.out.println(temp2.get(0).getTheater_id());
			System.out.println(the.getTheater_id());
			assertTrue(temp2.get(0).equals(the));
		}
	
	}
}

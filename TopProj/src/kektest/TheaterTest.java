package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kek.*;
import kekdao.*;

public class TheaterTest extends Assert{
	
	private TheaterDao tD = Factory.getInstance().getTheaterDao();
	
	@DataProvider
	public Object[][] test() {
		return new Object[][] {
			{"Volnov", 1},
			{null, 3},
			{"NotExc", 0},
		};
	}
	
	@Test(dataProvider = "test")
	public void getByNameTest(String name, int count) {
		List<Theater> t = tD.getAll();
		assertNotNull(t);
		List<Theater> tt = tD.getByName(name);
		System.out.println(tt.size());
		assertTrue(count == tt.size());
		if (tt.size() > 0 && tt.size() != 3) {
			assertTrue(tt.get(0).getName().equals(name));
		}
	}
	
	@DataProvider
	public Object[][] halls() {
		return new Object[][] {
			{1, 2},
			{2, 1},
		};
	}
	
	@Test(dataProvider = "halls")
	public void getHallsTest(int th_id, int count) {
		Theater a = new Theater();
		a.setTheater_id(th_id);
		List<Hall> temp = tD.getHalls(a);
		assertTrue(temp.size() == count);
	}
}

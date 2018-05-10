package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kek.*;
import kekdao.*;

public class PlaceTest extends Assert{
	private PlaceDao pD = Factory.getInstance().getPlaceDao();
	
	@DataProvider
	public Object[][] kekr() {
		return new Object[][] {
			{1, 1, 1, 1},
			{10, 10, 10, 0},
			{1, 0, 0, 4},
		};
	}
	
	@Test(dataProvider = "kekr")
	public void getByParamTest(int hall_id, int row, int num, int n) {
		List<Place> places = pD.getAll();
		assertNotNull(places);
		List<Place> temp = pD.getByParam(hall_id, row, num);
		if (temp != null) {
			assertTrue(n == temp.size());
		} else {
			assertTrue(n == 0);
		}
	}
}

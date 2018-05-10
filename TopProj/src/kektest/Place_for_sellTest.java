package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import kek.*;
import kekdao.*;

public class Place_for_sellTest extends Assert{
	private Place_for_sellDao psD = Factory.getInstance().getPlace_for_sellDao();
	private ShowDao sD = Factory.getInstance().getShowDao();
	
	@DataProvider
	public Object[][] Dat() {
		return new Object[][] {
			{1, 3},
			{2, 1},
		};
	}
	
	@Test(dataProvider = "Dat")
	public void getByShowTest(int id, int siz) {
		List<Place_for_sell> pfs = psD.getAll();
		assertNotNull(pfs);
		Shows temp = sD.getById(id);
		List<Place_for_sell> temp2 = psD.getByShow(temp);
		assertNotNull(temp2);
		assertTrue(temp2.size() == siz);
	}
}

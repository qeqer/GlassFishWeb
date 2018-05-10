package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kek.*;
import kekdao.*;

public class WorkerTest extends Assert{
	private WorkerDao wD = Factory.getInstance().getWorkerDao();
	
	@DataProvider
	public Object[][] Worker() {
		return new Object[][] {
				{"Alisa", "Vox", 1},
				{null, null, 0},
				{"Alisa", null, 0},
				{null, "Vox", 1},
		};
	}
	
	@Test(dataProvider = "Worker")
	public void getByNameTest(String name, String last_name, int count) {
		List<Worker> temp = wD.getByName(name, last_name);
		assertNotNull(temp);
		System.out.println(temp.size());
		assertTrue(temp.size() == count);
		if (temp.size() > 0) {
			if (name != null) {
				assertTrue(temp.get(0).getName().equals(name));
			}
			if (last_name != null) {
				assertTrue(temp.get(0).getLast_name().equals(last_name));
			}
		}
	}
}

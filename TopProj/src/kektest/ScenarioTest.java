package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kek.Factory;
import kek.Scenario;
import kekdao.ScenarioDao;

public class ScenarioTest extends Assert{
	private ScenarioDao sD = Factory.getInstance().getScenarioDao();
	
	@DataProvider
	public Object[][] ScenData() {
		return new Object[][] {
			{"Goblin", null, 1},
			{null, "Great Things", 1},
			{"Homer", "Great Things", 1},
		};
	}
	
	@Test(dataProvider = "ScenData")
	public void getByParam(String author_name, String name, int count) {
		List<Scenario> temp = sD.getByParam(author_name, name);
		assertNotNull(temp);
		assertTrue(temp.size() == count);
		if (author_name != null) {
			assertTrue(temp.get(0).getAuthor().equals(author_name));
		}
		if (name != null) {
			assertTrue(temp.get(0).getSource_name().equals(name));
		}
	}
}

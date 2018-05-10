package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import kek.*;
import kekdao.*;

public class ShowTest extends Assert{
	private ShowDao sD = Factory.getInstance().getShowDao();
	private TheaterDao tD = Factory.getInstance().getTheaterDao();
	private ScenarioDao ssD = Factory.getInstance().getScenarioDao();
	
	@Test
	public void getByThScTest() {
		Theater tempth = tD.getById(1);
		Scenario tempsc = ssD.getById(1);
		List<Shows> temp = sD.getByScTh(tempsc, tempth);
		assertNotNull(temp);
		assertTrue(temp.size() == 2);
		
	}
	
	@Test
	public void getShowsTheater() {
		Shows temp = new Shows();
		temp.setShow_id(1);
		Theater test = sD.getShowsTheater(temp);
		assertNotNull(test);
		assertTrue(test.getTheater_id() == 1);
	}
}

package kektest;

import org.testng.annotations.Test;

import java.util.List;

import org.testng.Assert;

import kek.*;
import kekdao.*;

public class Worker_in_ShowTest extends Assert{
	private Worker_in_showDao wtD = Factory.getInstance().getWorker_in_showDao();
	private ShowDao tD = Factory.getInstance().getShowDao();
	@Test
	public void getByShowTest() {
		List<Worker_in_show> wt = wtD.getAll();
		assertNotNull(wt);
		List<Shows> t = tD.getAll();
		assertNotNull(t);
		for (Shows the : t) {
				List<Worker>temp1 = wtD.getByShow(the);
				if (temp1.size() > 0) {
				List<Shows>temp2 = wtD.getByWorker(temp1.get(0));
				System.out.println(temp2.get(0).getShow_id());
				System.out.println(the.getShow_id());
				assertTrue(temp2.get(0).equals(the));
			}
		}
	
	}
}

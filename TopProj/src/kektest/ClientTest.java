package kektest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kek.*;
import kekdao.*;


public class ClientTest extends Assert{
	private ClientDao cD = Factory.getInstance().getClientDao();
	
	@DataProvider
	public Object[][] clientData() {
		return new Object[][] {
				{"Vasya", "Vasya"},
				{"Olya", "Kechko"},
				{null, "Monya"},
		};
	}
	
	@Test(dataProvider = "clientData") //Testing genericDaoImpl and ClientDao
	public void getByNameLastTest(String name, String lastName) {
		Integer count = cD.getAll().size();
		assertNotNull(count);
		System.out.println("Clients is not null");
		Client cl = new Client();
		cl.setLast_name(lastName);
		cl.setName(name);
		cD.create(cl);
		if (lastName == null) {
			return;
		}
		List<Client> tmpcl = cD.getByNameLast(name, lastName);
		assertFalse(tmpcl.size() == 0);
		System.out.println("Found added client by Name");
		int tmpId = tmpcl.get(0).getClient_id();
		Client tmp2cl = cD.getById(tmpId);
		assertNotNull(tmp2cl);
		System.out.println("Found added client by Id");
		tmp2cl.setLast_name("MegaTopKekLolCheburek");
		cD.update(tmp2cl);
		Client tmp3cl = cD.getById(tmpId);
		assertEquals(tmp3cl.getName(),  tmp2cl.getName());
		assertEquals(tmp3cl.getLast_name(), tmp2cl.getLast_name());
		assertEquals(tmp3cl.getLast_name(), "MegaTopKekLolCheburek");
		System.out.println("Changing Names correct");
		cD.delete(tmp3cl);
		tmp3cl = cD.getById(tmpId);
		assertNull(tmp3cl);
		System.out.println("Deleting correct");
	}
}

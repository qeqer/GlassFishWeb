package kek;

import kekdao.*;
import kek.Factory;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BookingDao bD = Factory.getInstance().getBookingDao();
		ClientDao cD = Factory.getInstance().getClientDao();
		Place_for_sellDao psD = Factory.getInstance().getPlace_for_sellDao();
		PlaceDao pD = Factory.getInstance().getPlaceDao();
		ScenarioDao sD = Factory.getInstance().getScenarioDao();
		ShowDao shD = Factory.getInstance().getShowDao();
		TheaterDao tD = Factory.getInstance().getTheaterDao();
		Worker_in_showDao wsD = Factory.getInstance().getWorker_in_showDao();
		Worker_in_theaterDao wtD = Factory.getInstance().getWorker_in_theaterDao();
		WorkerDao wD = Factory.getInstance().getWorkerDao();
		
		System.out.println("MAIN");
	}	
}
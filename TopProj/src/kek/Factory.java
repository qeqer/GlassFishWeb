package kek;

import kekdao.*;


public class Factory {
	private static BookingDao bk = null;
	private static ClientDao cl = null;
	private static Place_for_sellDao plsl = null;
	private static PlaceDao pl = null;
	private static ScenarioDao sc = null;
	private static ShowDao sh = null;
	private static TheaterDao th = null;
	private static Worker_in_showDao wosh = null;
	private static Worker_in_theaterDao woth = null;
	private static WorkerDao wo = null;
	private static HallDao h = null;
	private static Factory instance = null;
	
	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	public HallDao getHallDao() {
		if (h == null) {
			h = new HallDaoImpl(Hall.class);
		}
		return h;
	}
	
	public BookingDao getBookingDao() {
		if (bk == null) {
			bk = new BookingDaoImpl(Booking.class);
		}
		return bk;
	}

	public ClientDao getClientDao() {
		if (cl == null) {
			cl = new ClientDaoImpl(Client.class);
		}
		return cl;
	}

	public Place_for_sellDao getPlace_for_sellDao() {
		if (plsl == null) {
			plsl = new Place_for_sellDaoImpl(Place_for_sell.class);
		}
		return plsl;
	}
	
	public PlaceDao getPlaceDao() {
		if (pl == null) {
			pl = new PlaceDaoImpl(Place.class);
		}
		return pl;
	}
	
	public ScenarioDao getScenarioDao() {
		if (sc == null) {
			sc = new ScenarioDaoImpl(Scenario.class);
		}
		return sc;
	}
	
	public ShowDao getShowDao() {
		if (sh == null) {
			sh = new ShowDaoImpl(Shows.class);
		}
		return sh;
	}
	
	public TheaterDao getTheaterDao() {
		if (th == null) {
			th = new TheaterDaoImpl(Theater.class);
		}
		return th;
	}
	
	public Worker_in_showDao getWorker_in_showDao() {
		if (wosh == null) {
			wosh = new Worker_in_showDaoImpl(Worker_in_show.class);
		}
		return wosh;
	}
	
	public Worker_in_theaterDao getWorker_in_theaterDao() {
		if (woth == null) {
			woth = new Worker_in_theaterDaoImpl(Worker_in_theater.class);
		}
		return woth;
	}
	
	public WorkerDao getWorkerDao() {
		if (wo == null) {
			wo = new WorkerDaoImpl(Worker.class);
		}
		return wo;
	}
	
}
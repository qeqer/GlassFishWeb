package kek;

import java.util.Date;

public class tempSh {
	int show_id;
	
	int theater_id;
	
	String sc_name;
	int scenario_id;
	Date dat;
	int duration;
	String theater_name;
	
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public int getScenario_id() {
		return scenario_id;
	}
	public void setScenario_id(int scenario_id) {
		this.scenario_id = scenario_id;
	}
	public String getTheater_name() {
		return theater_name;
	}
	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public tempSh() {}
	
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	public Date getDat() {
		return dat;
	}
	public void setDat(Date dat) {
		this.dat = dat;
	};
	
	
};

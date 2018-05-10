package kek;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "shows")
public class Shows{
	@Id
	@Column(name = "show_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int show_id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "hall_id")
	private Hall hall;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "scenario_id")
	private Scenario scenario;
	
	@Column(name = "duration")
	private int duration;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "dat")
	private Date dat;
	
	public Date getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Shows() {};
	
	public Shows (int show_id, Hall hall, Scenario scenario, int duration) {
		this.show_id = show_id;
		this.hall = hall;
		this.scenario = scenario;
		this.duration = duration;
	}
	
	public boolean equals(Shows sh) {
		if (sh == null)
			return false;
		if (this.show_id == sh.show_id)
			return true;
		else
			return false;
	}
}

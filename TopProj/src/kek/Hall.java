package kek;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hall")
public class Hall {
	@Id
	@Column(name = "hall_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hall_id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "theater_id") 
	private Theater theater;
	
	@Column(name = "num")
	private int num;
	
	public int getHall_id() {
		return hall_id;
	}

	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Hall() {};
	
	public Hall(int hall_id, Theater theater, int num) {
		this.theater = theater;
		this.hall_id = hall_id;
		this.num = num;
	}
	
	public boolean equals(Hall hall) {
		if (hall == null)
			return false;
		if (this.hall_id == hall.hall_id)
			return true;
		else
			return false;
	}
	
	
}


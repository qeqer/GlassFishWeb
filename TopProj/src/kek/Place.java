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
@Table(name = "places")
public class Place {
	@Id
	@Column(name = "place_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int place_id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "hall_id")
	private Hall hall_id;
	
	@Column(name = "row_num")
	private int row_num;
	
	@Column(name = "num")
	private int num;
	
	@Column(name = "type")
	private char type;

	public int getPlace_id() {
		return place_id;
	}

	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}

	public Hall getHall() {
		return hall_id;
	}

	public void setHall(Hall hall) {
		this.hall_id = hall;
	}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public Place() {};
	
	public Place(int place_id, Hall hall, int row_num, int num) {
		this.place_id = place_id;
		this.hall_id = hall;
		this.row_num = row_num;
		this.num = num;
	}
	
	public boolean equals(Place place) {
		if (place == null)
			return false;
		if (this.place_id == place.place_id || 
				(this.row_num == place.row_num &&
				this.num == place.num &
				this.hall_id == place.hall_id))
			return true;
		else
			return false;
	}
}

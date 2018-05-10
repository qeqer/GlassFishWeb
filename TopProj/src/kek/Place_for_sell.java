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
@Table(name = "place_for_sell")
public class Place_for_sell {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "free")
	private int free;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "show_id")
	private Shows show;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "place_id")
	private Place place;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Place_for_sell() {};
	
	public Place_for_sell(int price, int free, Shows show_id, Place place_id) {
		this.place = place_id;
		this.show = show_id;
		this.free = free;
		this.price = price;
	}
	
	public boolean equals(Place_for_sell ps) {
		if (ps == null)
			return false;
		if ((this.place.equals(ps.place) &&
				this.show.equals(ps.show)) || ps.id == this.id)
			return true;
		else
			return false;
	}
	
}

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
@Table(name = "booking")
public class Booking {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "place_id")
	private Place_for_sell place;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Place_for_sell getPlace() {
		return place;
	}

	public void setPlace(Place_for_sell place) {
		this.place = place;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Booking() {};
	
	public boolean equals(Booking booking) {
		if (booking == null)
			return false;
		if (this.place.equals(booking.place)&&
			this.client.equals(booking.client))
			return true;
		else
			return false;
	}
}

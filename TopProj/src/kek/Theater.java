package kek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theater")
public class Theater {
	@Id
	@Column(name = "theater_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theater_id;
	
	@Column(name = "address", length = 128)
	private String address;
	
	@Column(name = "name", length = 64)
	private String name;
	
	@Column(name = "bio", length = 256)
	private String bio;
	
	
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	public Theater() {};
	
	public Theater(int theater_id, String address, String name, String bio) {
		this.theater_id = theater_id;
		this.address = address;
		this.name = name;
		this.bio = bio;
	}
	
	public boolean equals(Theater th) {
		if (th == null)
			return false;
		if (this.theater_id == th.theater_id)
			return true;
		else
			return false;
	}
}

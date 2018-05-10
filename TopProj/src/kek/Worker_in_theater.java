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
@Table(name = "worker_in_theater")
public class Worker_in_theater {
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
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "worker_id")
	private Worker worker_id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "theater_id")
	private Theater theater_id;
	
	@Column(name = "role", length = 45)
	private String role;
	
	public Worker getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(Worker worker_id) {
		this.worker_id = worker_id;
	}

	public Theater getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(Theater theater_id) {
		this.theater_id = theater_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Worker_in_theater() {};
	
}

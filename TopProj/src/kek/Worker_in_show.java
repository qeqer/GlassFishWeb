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
@Table(name = "worker_in_show")
public class Worker_in_show {
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
	@JoinColumn(name = "show_id")
	private Shows show_id;
	
	@Column(name = "role", length = 45)
	private String role;
	
	public Worker getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(Worker worker_id) {
		this.worker_id = worker_id;
	}

	public Shows getShow_id() {
		return show_id;
	}

	public void setShow_id(Shows show_id) {
		this.show_id = show_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Worker_in_show() {};
	
}

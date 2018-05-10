package kek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker {
	@Id
	@Column(name = "worker_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int worker_id;
	
	@Column(name = "last_name", length = 45)
	private String last_name;
	
	@Column(name = "name", length = 45)
	private String name;
	
	@Column(name = "bio", length = 256)
	private String bio;

	public int getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public Worker() {};
	
	public Worker(int worker_id, String last_name, String name, String bio) {
		this.worker_id = worker_id;
		this.last_name = last_name;
		this.name = name;
		this.bio = bio;
	}

	public boolean equals(Worker wr) {
		if (wr == null)
			return false;
		if (this.worker_id == wr.worker_id)
			return true;
		else
			return false;
	}
}

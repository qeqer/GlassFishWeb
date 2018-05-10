package kek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int client_id;
	
	@Column(name = "name", length = 45)
	private String name;
	
	@Column(name = "last_name", length = 45)
	private String last_name;

	@Column(name = "password", length = 45)
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Client() {};
	
	public boolean equals(Client client) {
		if (client == null)
			return false;
		if (this.client_id == client.client_id)
			return true;
		else
			return false;
	}
}

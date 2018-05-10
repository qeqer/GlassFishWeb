package kek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "scenario")
public class Scenario {
	@Id
	@Column(name = "scenario_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scenario_id;
	
	@Column(name = "source_name", length = 256)
	private String source_name;
	
	@Column(name = "Author", length = 128)
	private String author;
	
	public int getScenario_id() {
		return scenario_id;
	}

	public void setScenario_id(int scenario_id) {
		this.scenario_id = scenario_id;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String eauthor) {
		this.author = eauthor;
	}
	
	public Scenario() {};
	
	public Scenario(int scenario_id, String source_name, String Author) {
		this.scenario_id = scenario_id;
		this.source_name = source_name;
		this.author = Author;
	}
	
	public boolean equals(Scenario sce) {
		if (sce == null)
			return false;
		if (this.scenario_id == sce.scenario_id)
			return true;
		else
			return false;
	}
	
}

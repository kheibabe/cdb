package cdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="company")
@Table(name="company")
public class Company {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	public Company(int id, String name) {
		this.id = id;
		this.name = name;
}

    public Company() {
    	
	}

	public String getName() {
		return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
    	return "Company [id=" + id + ", name=" + name + " ]";
    }
}
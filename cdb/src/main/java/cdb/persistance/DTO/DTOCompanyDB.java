package cdb.persistance.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity(name="DTOCompanyDB")
@Table(name="company")

public class DTOCompanyDB {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	public int id;
	public String name;

	public DTOCompanyDB() {
		
	}

	public DTOCompanyDB(int company, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "DTOCompanyDB [id=" + id + ", name=" + name + "]";
	}
	
	


}

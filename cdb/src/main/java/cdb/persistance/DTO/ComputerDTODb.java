package cdb.persistance.DTO;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "computer")
public class ComputerDTODb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate introduced;
	private LocalDate discontinued;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "company_id")
	private DTOCompanyDB dtoCompanyDB;
	
	
	public ComputerDTODb() {
	}
	
	
	public ComputerDTODb(int id, String name, LocalDate introduced, LocalDate discontinued,
			DTOCompanyDB dtoCompanyDB) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.dtoCompanyDB = dtoCompanyDB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getIntroduced() {
		return introduced;
	}
	public void setIntroduced(LocalDate introduced) {
		this.introduced = introduced;
	}
	public LocalDate getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(LocalDate discontinued) {
		this.discontinued = discontinued;
	}
	public DTOCompanyDB getDTOCompanyDB() {
		return dtoCompanyDB;
	}
	public void setDtoCompanyDbService(DTOCompanyDB dtoCompanyDB) {
		this.dtoCompanyDB = dtoCompanyDB;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ComputerDTODb [id=" + id + ", name=" + name + ", introduced=" + introduced + ", discontinued="
				+ discontinued + ", dtoCompanyDB=" + dtoCompanyDB + "]";
	}
	
}

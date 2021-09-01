package cdb.persistance.DTO;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="computer")
@Component("ComputerDTO")
public class ComputerDTO {

	@XmlElement(name="id")
	private int id;

	@XmlElement(name="name")
	private String name;
	@XmlElement(name="introduced")
	private String introduced;
	@XmlElement(name="discontinued")
	private String discontinued;
	@XmlElement(name="companyID")
	private String companyID;

	private ComputerDTO(ComputerDTOBuilder computerDTOBuilder) {
		this.name = computerDTOBuilder.name;
		this.introduced = computerDTOBuilder.introduced;
		this.discontinued = computerDTOBuilder.discontinued;
		this.companyID = computerDTOBuilder.companyID;
	}

	public ComputerDTO() {
	}

	public String getName() {
		return name;
	}

	public String getIntroduced() {
		return introduced;
	}

	@Override
	public String toString() {
		return "ComputerDTO [name=" + name + ", introduced=" + introduced + ", discontinued=" + discontinued
				+ ", companyID=" + companyID + "]";
	}

	public String getDiscontinued() {
		return discontinued;
	}

	public String getCompanyID() {
		return companyID;
	}

	public static class ComputerDTOBuilder {

		private String name;

		private String introduced;

		private String discontinued;

		private String companyID;

		public ComputerDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public ComputerDTOBuilder setIntroduced(String introduced) {
			this.introduced = introduced;
			return this;
		}

		public ComputerDTOBuilder setDiscontinued(String discontinued) {
			this.discontinued = discontinued;
			return this;
		}

		public ComputerDTOBuilder setCompanyID(String companyID) {
			this.companyID = companyID;
			return this;
		}

		public ComputerDTO build() {
			return new ComputerDTO(this);
		}

	}

}

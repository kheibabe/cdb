package cdb.persistance.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component("ComputerDTO")
public class ComputerDTO {


	private int id;

	private String name;

	private String introduced;
	
	private String discontinued;

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

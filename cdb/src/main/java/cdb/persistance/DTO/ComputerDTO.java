package cdb.persistance.DTO;

import java.time.LocalDate;

import cdb.model.Company;

public class ComputerDTO {

	/*  private Branch(BranchBuilder builder) {
    // Fields controls
 
    name = builder.name;
    description = Optional.ofNullable(builder.description);
    owner = new Username(builder.owner);
 }
 
  public static BranchBuilder builder() {
    return new BranchBuilder();
  }
 
  // Business methods
 
  public static class BranchBuilder {
    private String name;
    private String description;
    private String owner;
 
    public BranchBuilder name(String name) {
      this.name = name;
 
      return this;
    }
    public BranchBuilder description(String description) {
      this.description = description;
      return this;
    }
    public BranchBuilder owner(String owner) {
      this.owner = owner;
      return this;
    }
    public Branch build() {
      return new Branch(this);
    }
  }
}
*/
	
	// private Branch(BranchBuilder builder)
	

	private String name ;

	private String introduced ;

	private String discontinued ;

	private String companyID ;

	private ComputerDTO(ComputerDTOBuilder computerDTOBuilder) {
		this.name = computerDTOBuilder.name;
		this.introduced = computerDTOBuilder.introduced;
		this.discontinued = computerDTOBuilder.discontinued;
		this.companyID = computerDTOBuilder.companyID;
	}

	public String getName() {
		return name;
	}

	public String getIntroduced() {
		return introduced;
	}

	public String getDiscontinued() {
		return discontinued;
	}

	public String getCompanyID() {
		return companyID;
	}

public static class ComputerDTOBuilder {

		
		
		private String name ;

		private String introduced ;
		
		private String discontinued ;

		private String companyID ;


		public ComputerDTOBuilder(String name) {
			this.name = name;
			this.introduced = "";
			this.discontinued = "";
			this.companyID ="";
		}
	

		public ComputerDTOBuilder introduced(String introduced) {
			this.introduced = introduced;
			return this;
		}

		public ComputerDTOBuilder discontinued(String discontinued) {
			this.discontinued = discontinued;
			return this;
		}

		public ComputerDTOBuilder companyID(String companyID) {
			this.companyID = companyID;
			return this;
		}
		
		public ComputerDTO build() {
			return new ComputerDTO(this);
		}

	}
	
	
}

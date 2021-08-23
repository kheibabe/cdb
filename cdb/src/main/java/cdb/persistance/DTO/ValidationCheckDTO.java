package cdb.persistance.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component("ValidationCheckDTO")
public class ValidationCheckDTO {

	public void checkName(ComputerDTO computerDTO) throws Exception {
			String computerName = computerDTO.getName();
			if( computerName.isEmpty()) {
				throw new Exception("invalid name") ;
			}
	}
	
	public void checkID(ComputerDTO computerDTO) throws Exception {
		String companyID = computerDTO.getCompanyID();
		if (companyID.isEmpty()) {
			throw new Exception("Cet ID est nul et non avenu");
		}
		else {
			Integer.parseInt(companyID);
		}
	}
	
	public void checkDate(ComputerDTO computerDTO) throws Exception {
		String computerIntroduced = computerDTO.getIntroduced();
		String computerDiscontinued = computerDTO.getDiscontinued();
		
		if (computerIntroduced.isEmpty() || computerIntroduced == null || computerDiscontinued == null || computerDiscontinued.isEmpty()) {
			throw new Exception("Date nulle zéro bouh");
		}
		
		else {
			LocalDate.parse(computerIntroduced);
			LocalDate.parse(computerDiscontinued);
			
			if(LocalDate.parse(computerIntroduced).isAfter(LocalDate.parse(computerDiscontinued))) {
				throw new Exception("lol nope c'est impossible ça");
			}
				
				//introduced doit être < discontinued
		}
	}
	
}

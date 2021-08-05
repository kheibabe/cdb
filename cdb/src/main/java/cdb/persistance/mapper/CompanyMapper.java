package cdb.persistance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import cdb.model.Company;

@Component("companyMapper")
public class CompanyMapper {

	// private static CompanyMapper instance;
	
	/* public static CompanyMapper getInstance() {
		
		if(instance == null) {
			instance = new CompanyMapper();
		}
		return null;
	}
	*/
	
	public CompanyMapper() {
		
	}

	public Company mapToCompany(ResultSet rs) {
		Company company = new Company();
		try {
			int id = rs.getInt("id");
			String name = rs.getString("name");
		
			company.setId(id);
			company.setName(name);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return company;
	}

	
}

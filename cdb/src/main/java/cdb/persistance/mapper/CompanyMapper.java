package cdb.persistance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cdb.model.Company;
import cdb.model.Computer;

@Component("companyMapper")
public class CompanyMapper implements RowMapper<Company> {

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
	
	@Override
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		Company company = new Company();
		company.setId(rs.getInt("id"));
		company.setName(rs.getString("name"));
		/*
		 * computer.setIntroduced(rs.getDate("introduced"));
		 * computer.setDiscontinued(rs.getDate("discontinued"));
		 * user.setUpdatedTime(rs.getDate("UPDATEDTIME"));
		*/

		return company;
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

package cdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.CdbConnection;
import cdb.persistance.CompanyDAO;

@Service
public class CompanyService {
	
	private CompanyDAO companyDAO; // = new CompanyDAO();
	/* private static CompanyService instance;

	public static CompanyService getInstance() {
		if(instance == null) {
			instance = new CompanyService();
		}
		return instance;
	}
	*/
	
	public CompanyService(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
	public List<Company> getAllCompany() {
		return companyDAO.getAllCompany();
	}
	
	public Company getCompany(int id) {
		return companyDAO.getCompanyById(id);
	}

	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		companyDAO.deleteCompany(id);
	}
	
}




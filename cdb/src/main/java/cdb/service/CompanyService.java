package cdb.service;

import java.util.List;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.CdbConnection;
import cdb.persistance.CompanyDAO;

public class CompanyService {
	
	private CompanyDAO companyDAO = new CompanyDAO();
	private static CompanyService instance;

	public static CompanyService getInstance() {
		if(instance == null) {
			instance = new CompanyService();
		}
		return instance;
	}
	
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyDAO.getAllCompany();
	}
	
	public Company getCompany(int id) {
		return companyDAO.getCompanyById(id);
	}
	
}




package cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.service.CompanyService;

@Controller
public class CompanyController {
	
	private CompanyService companyService; // = new CompanyService();
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	public List<Company> getAllCompany() {
		return companyService.getAllCompany();
	}
	
	public Company getCompanyById(int id) {
		return companyService.getCompany(id);
	}
}

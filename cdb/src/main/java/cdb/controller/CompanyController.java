package cdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.DTO.DTOCompanyDB;
import cdb.service.CompanyService;

@Controller
public class CompanyController {
	
	private CompanyService companyService; // = new CompanyService();
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	public List<DTOCompanyDB> getAllCompany() {
		return companyService.getAllCompany();
	}
	
	public Optional<DTOCompanyDB> getCompanyById(int id) {
		return companyService.getCompany(id);
	}
	
	public void deleteComputer(int id) {
		companyService.deleteCompany(id);
	}
}

package cdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.CdbConnection;
import cdb.persistance.CompanyDAO;
import cdb.persistance.CompanyRepository;
import cdb.persistance.DTO.ComputerDTODb;
import cdb.persistance.DTO.DTOCompanyDB;

@Service
public class CompanyService {
	
	private CompanyDAO companyDAO;
	private CompanyRepository companyRepository;// = new CompanyDAO();
	/* private static CompanyService instance;

	public static CompanyService getInstance() {
		if(instance == null) {
			instance = new CompanyService();
		}
		return instance;
	}
	*/
	
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
		
	}
	
	public List<DTOCompanyDB> getAllCompany() {
		return companyRepository.findAll();
	}
	
	public Optional <DTOCompanyDB> getCompany(int id) {
		return companyRepository.findById(id);
	}
	

	public void deleteCompany(int id) {
		companyRepository.deleteById(id);
	}
	
}




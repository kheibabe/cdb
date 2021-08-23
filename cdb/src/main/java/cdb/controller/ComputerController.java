package cdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cdb.model.Computer;
import cdb.persistance.DTO.ComputerDTODb;
import cdb.service.ComputerService;

@Controller
public class ComputerController {
	
	private ComputerService computerService ;
	
	@Autowired
	public ComputerController(ComputerService computerService) {
		this.computerService = computerService;
	}

	public List<ComputerDTODb> getAllComputer() {
		return computerService.getAllComputer();
	}
	
	
	public Optional<ComputerDTODb> getComputerById(int id) {
		return computerService.getComputer(id);
	}
	
	public void deleteComputer(int id) {
		computerService.deleteComputer(id);
	}

	public void deleteComputerWithCnyId(int id) {
		computerService.deleteComputerWithCnyId(id);
	}
	
	/*
	public void editCPR(int id, ComputerDTODb computerDTODb) {
		computerService.editCPR(id, computerDTODb);
	}*/

}
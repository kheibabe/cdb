package cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cdb.model.Computer;
import cdb.service.ComputerService;

@Controller
public class ComputerController {
	
	private ComputerService computerService ;
	/* 
	 * = new ComputerService(ComputerDAO);
	 */
	@Autowired
	public ComputerController(ComputerService computerService) {
		this.computerService = computerService;
	}

	public List<Computer> getAllComputer() {
		return computerService.getAllComputer();
	}
	
	
	public Computer getComputerById(int id) {
		return computerService.getComputer(id);
	}


}
package cdb.controller;

import java.util.List;

import cdb.model.Computer;
import cdb.service.ComputerService;


public class ComputerController {
	
	private ComputerService computerService = new ComputerService();

	public List<Computer> getAllComputer() {
		// TODO Auto-generated method stub
		return computerService.getAllComputer();
	}
	
	public Computer getComputerById(int id) {
		return computerService.getComputer(id);
	}


}
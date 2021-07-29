package cdb.service;

import java.util.List;

import cdb.model.Computer;
import cdb.persistance.ComputerDAO;

public class ComputerService {

	private ComputerDAO computerDAO = ComputerDAO.getInstance();
	private static ComputerService instance;

	public static ComputerService getInstance() {
		if(instance == null) {
			instance = new ComputerService();
		}
		return instance;
	}
	
	public List<Computer> getAllComputer() {
		// TODO Auto-generated method stub
		return computerDAO.getAllComputer();
	}
	
	public Computer getComputer(int id) {
		return computerDAO.getComputerById(id);
	}
}

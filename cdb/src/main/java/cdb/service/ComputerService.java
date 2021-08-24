package cdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cdb.model.Computer;
import cdb.persistance.ComputerDAO;
import cdb.persistance.ComputerRepository;
import cdb.persistance.DTO.ComputerDTO;
import cdb.persistance.DTO.ComputerDTODb;
@Service
@Transactional
public class ComputerService {

	private ComputerDAO computerDAO;
	private ComputerRepository computerRepository;
	
	/*
	 * = ComputerDAO.getInstance();
	
	private static ComputerService instance;
	

	public static ComputerService getInstance() {
		if(instance == null) {
			instance = new ComputerService();
		}
		return instance;
	}
	 */
	@Autowired
	public ComputerService(ComputerRepository computerRepository) {
		this.computerRepository = computerRepository;
	}
	
	public List<ComputerDTODb> getAllComputer() {
		return computerRepository.findAll();
	}
	
	
	public Optional<ComputerDTODb> getComputer(int id) {
		return computerRepository.findById(id);
	}

	public long countAllComputer() {
		return computerRepository.count();
	}
	
	public void addComputer(ComputerDTODb computerDTODb) {
		computerRepository.save(computerDTODb);
	}
	
	public void deleteComputer(int id) {
		computerRepository.deleteById(id);
	}
	
	public void deleteComputerWithCnyId(int id) {
		computerRepository.deleteById(id);
	}
	
	public void editCPR(ComputerDTODb dto) {
		computerRepository.save(dto);
		// Il suffit d'ajouter id de CPR dans le cli pour que ça édite au lieu de créer.
		}
		
}

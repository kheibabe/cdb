package cdb.persistance;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.DTO.ComputerDTO;
import cdb.persistance.DTO.ComputerDTODb;

@Repository
public interface ComputerRepository extends JpaRepository<ComputerDTODb, Integer>{

	public Optional<ComputerDTODb> findById(int id);
	
	public void deleteById(int id);
	
	public List<ComputerDTODb> findAll();
	
	public long count();
	
	public ComputerDTODb update(ComputerDTODb computerDTODb);
	
	
}

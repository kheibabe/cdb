package cdb.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdb.model.Company;
import cdb.persistance.DTO.ComputerDTODb;
import cdb.persistance.DTO.DTOCompanyDB;

@Repository
public interface CompanyRepository extends JpaRepository<DTOCompanyDB, Integer>{
	
	public void deleteById(int id);
	
	public Optional<DTOCompanyDB> findById(int id);
	
	public List<DTOCompanyDB> findAll();
	
	// @Query(value = "DELETE FROM company WHERE id = :id ;")
	
	

}

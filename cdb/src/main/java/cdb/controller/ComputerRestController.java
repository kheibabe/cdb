package cdb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cdb.persistance.DTO.ComputerDTO;
import cdb.persistance.DTO.ComputerDTO.ComputerDTOBuilder;
import cdb.persistance.ComputerRepository;


@RequestMapping("/rest")
public class ComputerRestController {
	
private static final Logger logger = LoggerFactory.getLogger(ComputerRestController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer,ComputerDTOBuilder> computerData = new HashMap<Integer, ComputerDTOBuilder>();
	
	@RequestMapping(value = ComputerRestURI.DUMMY_CPR, method = RequestMethod.GET)
	public @ResponseBody ComputerDTOBuilder getDummyComputerDTO() {
		logger.info("Start getDummyEmployee");
		ComputerDTOBuilder computer = new ComputerDTOBuilder();
		computer.setName("Dummy");
		computer.setIntroduced("1993-02-21");
		computer.setDiscontinued("1993-02-26");
		computer.setCompanyID("3");
		computerData.put(9999, computer);
		return computer;
	}
	
	

	@RequestMapping(value = ComputerRestURI.GET_CPR, method = RequestMethod.GET)
	public @ResponseBody ComputerDTOBuilder getComputerDTOBuilder(@PathVariable("id") int id) {
		logger.info("Start getEmployee. ID="+id);
		
		return computerData.get(id);
	}
	
	@RequestMapping(value = "/computers", method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ComputerDTOBuilder> findAll() {
		logger.info("Start getAllEmployees.");
		List<ComputerDTOBuilder> computers = new ArrayList<ComputerDTOBuilder>();
		/* Set<Integer> empIdKeys = computerData.keySet();
		for(Integer i : empIdKeys){
			computers.add(computerData.get(i));
		}*/
		//System.out.println(computerData);
		return computerRepository.findAll();
	}
		/*
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}*/
	
}

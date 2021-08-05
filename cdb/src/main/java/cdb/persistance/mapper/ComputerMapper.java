package cdb.persistance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import cdb.model.Company;
import cdb.model.Computer;

@Component("computerMapper")
public class ComputerMapper {
	
	/*
	private static ComputerMapper instance;

	public static ComputerMapper getInstance() {
		if(instance == null) {
			instance = new ComputerMapper();
		}
		return instance;
	}*/
	
	public ComputerMapper () {
		
	}

	public Computer mapToComputer(ResultSet rs) {
		Computer computer = new Computer();
		try {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			// Le company
			computer.setId(id);
			computer.setName(name);
			// computer.setCompany());
			// System.out.println(rs.getString("introduced") == null );
			if (rs.getString("introduced")!= null) {
				computer.setIntroduced(rs.getDate("introduced").toLocalDate());
			}
			if (rs.getString("discontinued")!= null) {
				computer.setDiscontinued(rs.getDate("discontinued").toLocalDate());
			}

			if (rs.getString("company_id") != null) {
				computer.setCompany(new Company(Integer.parseInt(rs.getString("company_id")), rs.getString("company_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(computer);
		return computer;
	}
}

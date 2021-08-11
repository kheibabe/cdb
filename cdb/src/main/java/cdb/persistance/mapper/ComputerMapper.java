package cdb.persistance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.model.Computer.ComputerBuilder;

@Component("computerMapper")
public class ComputerMapper implements RowMapper<Computer> {
	
	// objet RowMapper permettant de mapper chaque enregistrement récupéré sur l'objet 

	/*
	 * private static ComputerMapper instance;
	 * 
	 * public static ComputerMapper getInstance() { if(instance == null) { instance
	 * = new ComputerMapper(); } return instance; }
	 */


	
	public ComputerMapper() {

	}

	@Override
	public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Computer computer = new Computer();
		computer.setId(rs.getInt("id"));
		computer.setName(rs.getString("name"));
		/*
		 * computer.setIntroduced(rs.getDate("introduced"));
		 * computer.setDiscontinued(rs.getDate("discontinued"));
		 * user.setUpdatedTime(rs.getDate("UPDATEDTIME"));
		*/

		if (rs.getString("introduced") != null) {
			computer.setIntroduced(rs.getDate("introduced").toLocalDate());
		}
		if (rs.getString("discontinued") != null) {
			computer.setDiscontinued(rs.getDate("discontinued").toLocalDate());
		}

		if (rs.getString("company_id") != null) {
			
			computer.setCompany(
					new Company(rs.getInt("company_id"), rs.getString("company_name")));
		}

		return computer;
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
			if (rs.getString("introduced") != null) {
				computer.setIntroduced(rs.getDate("introduced").toLocalDate());
			}
			if (rs.getString("discontinued") != null) {
				computer.setDiscontinued(rs.getDate("discontinued").toLocalDate());
			}

			if (rs.getString("company_id") != null) {
				computer.setCompany(
						new Company(Integer.parseInt(rs.getString("company_id")), rs.getString("company_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println(computer);
		return computer;
	}
}

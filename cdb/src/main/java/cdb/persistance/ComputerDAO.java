package cdb.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.mapper.ComputerMapper;

public class ComputerDAO {
	private static ComputerDAO instance;
	private CdbConnection cdbcn = CdbConnection.getInstance();
	private ComputerMapper computerMapper = ComputerMapper.getInstance();
	private static final String REQ_GET_ALL_COMPUTER = "SELECT * from computer;";

	
	public static ComputerDAO getInstance() {
		if(instance == null) {
			instance = new ComputerDAO();
		}
		return instance;
	}

	public List<Computer> getAllComputer() {
		List<Computer> listComputer = new ArrayList<>();

		try (Connection con = cdbcn.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_GET_ALL_COMPUTER);
			while (rs.next()) {
				
				Computer computer = computerMapper.mapToComputer(rs);
				
				listComputer.add(computer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listComputer;
	}
	
}

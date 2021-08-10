package cdb.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.Date;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.mapper.ComputerMapper;

@Repository 

public class ComputerDAO {
	// private static ComputerDAO instance;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private CdbConnection cdbcn; // = CdbConnection.getInstance();
	private ComputerMapper computerMapper; // = ComputerMapper.getInstance();
	private static final String REQ_GET_ALL_COMPUTER = "SELECT cpr.id, cpr.name, cpr.introduced, cpr.discontinued, cpr.company_id, cny.name as company_name from computer as cpr left join company as cny ON cpr.company_id = cny.id";
	private static final String REQ_GET_CPR_BY_ID = "SELECT cpr.id, cpr.name, cpr.introduced, cpr.discontinued, cpr.company_id, cny.name as company_name from computer as cpr left join company as cny ON cpr.company_id = cny.id WHERE cpr.id = :id";
	private static final String REQ_ADD_CPR = "INSERT INTO computer(name, introduced, discontinued, company_id) VALUES (?, ?, ?, ?);";
	private static final String REQ_COUNT_ALL_CPR = "SELECT COUNT(*) FROM computer;";
	private static final String REQ_DELETE_CPR = "DELETE FROM computer WHERE id = :id ;";
	
	
	/*
	public static ComputerDAO getInstance() {
		if(instance == null) {
			instance = new ComputerDAO();
		}
		return instance;
	}
	*/
	@Autowired
	public ComputerDAO(ComputerMapper computerMapper, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		
		this.computerMapper = computerMapper;
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public List<Computer> getAllComputer() {
		
		/*List<Computer> listComputer = new ArrayList<>();

		try (Connection con = cdbcn.getConnection()) {
			Statement stmt = con.createStatement(); // Objet créé à partir de l'objet connection qui permet d'envoyer requêtes SQL à la DB
			ResultSet rs = stmt.executeQuery(REQ_GET_ALL_COMPUTER);
			while (rs.next()) {
				
				Computer computer = computerMapper.mapToComputer(rs);
				
				listComputer.add(computer);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listComputer;
*/
		return jdbcTemplate.query(REQ_GET_ALL_COMPUTER, computerMapper);
		
	}
	
	
	public Computer getComputerById(int id) { // Optional ?
		
		 /* int id = 1;
		return namedParameterJdbcTemplate.queryForObject(
				REQ_GET_CPR_BY_ID, new Object[] { id }, computerMapper); */
		
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(
				REQ_GET_CPR_BY_ID, namedParameters, computerMapper);
		
		/*
		Computer computer = new Computer();
		ResultSet rs = null;
		
		try (Connection con = cdbcn.getConnection(); PreparedStatement stmt = con.prepareStatement(REQ_GET_CPR_BY_ID)) {
			
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
			computer = computerMapper.mapToComputer(rs);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return computer;*/
		
		
	}
	

	
	public void addComputer(Computer computer) {
      
        /* try (Connection con = cdbcn.getConnection(); PreparedStatement stmt =
            con.prepareStatement(REQ_ADD_CPR)) {
            stmt.setString(1, computer.getName());
            stmt.setDate(2, Date.valueOf(computer.getIntroduced()));
            stmt.setDate(3, Date.valueOf(computer.getDiscontinued()));
            stmt.setInt(4, computer.getCompany().getId());
            stmt.execute();
         
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        
        jdbcTemplate.update(REQ_ADD_CPR, computer.getName(), computer.getIntroduced(), computer.getDiscontinued(),
				computer.getCompany().getId());
	
    }


	public int countAllComputer() {
		
		
		/*
		int countAllComputer = 0;
		
		try (Connection con = cdbcn.getConnection(); 
				PreparedStatement stmt =
			            con.prepareStatement(REQ_COUNT_ALL_CPR)) {
			ResultSet rs = stmt.executeQuery();
			rs.next();
			countAllComputer = rs.getInt(1);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return countAllComputer;
		
		*/
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.queryForObject(
				REQ_COUNT_ALL_CPR, namedParameters, Integer.class);
		
	}
	
	
	
	public void deleteComputer(int id) {
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(
				REQ_DELETE_CPR, namedParameters);
		
	}
	
	
}

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
	private static final String REQ_DELETE_CPR_CNYID = "DELETE FROM computer WHERE company_id = :id ;";

	/*
	 * public static ComputerDAO getInstance() { if(instance == null) { instance =
	 * new ComputerDAO(); } return instance; }
	 */
	@Autowired
	public ComputerDAO(ComputerMapper computerMapper, JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.computerMapper = computerMapper;
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Computer> getAllComputer() {
		return jdbcTemplate.query(REQ_GET_ALL_COMPUTER, computerMapper);
	}

	public Computer getComputerById(int id) { // Optional ?

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(REQ_GET_CPR_BY_ID, namedParameters, computerMapper);

	}

	public void addComputer(Computer computer) {
		
		jdbcTemplate.update(REQ_ADD_CPR, computer.getName(), Date.valueOf(computer.getIntroduced()), Date.valueOf(computer.getDiscontinued()),
				computer.getCompany().getId());

	}

	public int countAllComputer() {

		SqlParameterSource namedParameters = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.queryForObject(REQ_COUNT_ALL_CPR, namedParameters, Integer.class);

	}

	public void deleteComputer(int id) {

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(REQ_DELETE_CPR, namedParameters);

	}

	public void deleteComputerWithCnyId(int id) {

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(REQ_DELETE_CPR_CNYID, namedParameters);

	}

}

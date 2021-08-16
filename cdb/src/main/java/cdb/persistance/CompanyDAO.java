package cdb.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.mapper.CompanyMapper;
import cdb.persistance.mapper.ComputerMapper;

@Repository
public class CompanyDAO {

	private JdbcTemplate jdbcTemplate;
	private CompanyMapper companyMapper;
	private static final String REQ_GET_ALL_COMPANY = "SELECT id, name FROM company;"; // On précise les champs pour
																						// sécuriser
	private static final String REQ_GET_COMPANY_BY_ID = "SELECT id, name FROM company WHERE id = :id ;";
	private static final String REQ_DELETE_CNY = "DELETE FROM company WHERE id = :id ;";
	private static final String REQ_DELETE_CPR_CNYID = "DELETE FROM computer WHERE company_id = :id ;";
	private CdbConnection cdbcn; 
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Autowired
	public CompanyDAO(CompanyMapper companyMapper, JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.companyMapper = companyMapper;
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		// this.cdbcn = cbdcn;
	}

	public List<Company> getAllCompany() {
		return jdbcTemplate.query(REQ_GET_ALL_COMPANY, companyMapper);
	}

	public Company getCompanyById(int id) { // Optional ?

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(REQ_GET_COMPANY_BY_ID, namedParameters, companyMapper);

	}
	
	@Transactional
	public void deleteCompany(int id) {

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(REQ_DELETE_CNY, namedParameters);
		namedParameterJdbcTemplate.update(REQ_DELETE_CPR_CNYID, namedParameters);

	}

}
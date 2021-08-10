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

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.mapper.CompanyMapper;
import cdb.persistance.mapper.ComputerMapper;


@Repository
public class CompanyDAO {

	// private static CompanyDAO instance;
	private JdbcTemplate jdbcTemplate;
	private CompanyMapper companyMapper; // = CompanyMapper.getInstance();
	private static final String REQ_GET_ALL_COMPANY = "SELECT id, name FROM company;"; // On précise les champs pour
																						// sécuriser
	private final String REQ_GET_COMPANY_BY_ID = "SELECT id, name FROM company WHERE id = :id ;";
	private CdbConnection cdbcn; // = CdbConnection.getInstance();
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/* public static CompanyDAO getInstance() {
		if (instance == null) {
			instance = new CompanyDAO();
		}
		return instance;
	}*/
	
	@Autowired
	public CompanyDAO(CompanyMapper companyMapper, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.companyMapper = companyMapper;
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		// this.cdbcn = cbdcn;
	}

	public List<Company> getAllCompany() {

		/* List<Company> listCompany = new ArrayList<>();

		try (Connection con = cdbcn.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_GET_ALL_COMPANY);
			while (rs.next()) {
				// listCompany.add(new Company(rs.getInt("id"), rs.getString("name")));

				Company company = companyMapper.mapToCompany(rs);

				listCompany.add(company);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listCompany;*/
		
		return jdbcTemplate.query(REQ_GET_ALL_COMPANY, companyMapper);
	}

	public Company getCompanyById(int id) { // Optional ?

		/* Company company = new Company();
		ResultSet rs = null;

		try (Connection con = cdbcn.getConnection();
				PreparedStatement stmt = con.prepareStatement(REQ_GET_COMPANY_BY_ID)) {

			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
			company = companyMapper.mapToCompany(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return company; */
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(
				REQ_GET_COMPANY_BY_ID, namedParameters, companyMapper);

	}

}
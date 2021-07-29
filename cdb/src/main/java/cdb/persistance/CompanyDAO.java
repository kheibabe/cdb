package cdb.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.mapper.CompanyMapper;
import cdb.persistance.mapper.ComputerMapper;

public class CompanyDAO {

	private static CompanyDAO instance;
	private CompanyMapper companyMapper = CompanyMapper.getInstance();
	private static final String REQ_GET_ALL_COMPANY = "SELECT id, name FROM company;"; // On précise les champs pour
																						// sécuriser
	private final String REQ_GET_COMPANY_BY_ID = "SELECT id, name FROM company WHERE id = ? ;";
	private CdbConnection cdbcn = CdbConnection.getInstance();

	public static CompanyDAO getInstance() {
		if (instance == null) {
			instance = new CompanyDAO();
		}
		return instance;
	}

	public List<Company> getAllCompany() {

		List<Company> listCompany = new ArrayList<>();

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

		return listCompany;
	}

	public Company getCompanyById(int id) { // Optional ?

		Company company = new Company();
		ResultSet rs = null;

		try (Connection con = cdbcn.getConnection();
				PreparedStatement stmt = con.prepareStatement(REQ_GET_COMPANY_BY_ID)) {

			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
			company = companyMapper.mapToCompany(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return company;

	}

}
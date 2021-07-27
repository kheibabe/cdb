package cdb.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdb.model.Company;

public class CompanyDAO {

	private static final String REQ_GET_ALL_COMPANY = "SELECT * from company;";
	private CdbConnection cdbcn = CdbConnection.getInstance();
	
	public List<Company> getAllCompany() {
		
		List <Company> listCompany = new ArrayList <> ();
		
		
		try( Connection con = cdbcn.getConnection() ) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_GET_ALL_COMPANY);
			while(rs.next()) {
				listCompany.add(new Company(rs.getInt("id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCompany;
	}

}

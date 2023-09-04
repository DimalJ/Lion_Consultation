package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpecialityAddDao {

	
	String insertSql = "INSERT INTO specialized "
			+ "( username,industry,region)"
			+ "VALUES"
			+ "(?, ?, ?)" ;
	
	
	
	public boolean addSpecialty(String username, String industry, String region) {
		
		Connection conn = DbConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement(insertSql);
			ps.setString(1, username);
			ps.setString(2, industry);
			ps.setString(3, region);
			
			int rowAffected= ps.executeUpdate();
			conn.close();
			ps.close();
			return rowAffected>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}

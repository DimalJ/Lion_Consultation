package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultantDao {

	
public boolean addAvailability(String username, String availableDate, String startTime,String finishTime) throws ClassNotFoundException {
        try {
        	Connection conn = DbConnection.getConnection();
            String sql = "INSERT INTO consultant_availability (username, available_date, start_time, finish_time) VALUES (?, ?, ?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, availableDate);
            pstmt.setString(3, startTime);
            pstmt.setString(4, finishTime);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package src.model.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.model.DAO.employeesDTO;

public class employeesDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "hr";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public employeesDTO getSelectOne() {
		getConn();
		employeesDTO dto = new employeesDTO();
		try {
			String sql = "select*from employees where wemployee_id=100";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setEmployee_id(rs.getString("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setHire_date(rs.getString("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission_pct(rs.getDouble("commission_pct"));
				dto.setManager_id(rs.getString("manager_id"));
				dto.setDepartment_id(rs.getString("department_id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return dto;
	}
	
	
}

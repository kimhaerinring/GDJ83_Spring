package com.sun.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		// SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값을 세팅하는 단계

		// 최종 전송 및 결과를 처리 하는 단계
		ResultSet rs = st.executeQuery();
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);

		}
		// 연결한 자원을 해체
		rs.close();
		st.close();
		con.close();
		return ar;

	}

	// detail가지고 오기
	public DepartmentDTO getDetail(int num) throws Exception {
		// 1.DB접속
		Connection con = dbConnection.getConnection();
		// 2.SQL문 작성
		String stl = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(stl);
		// 4. ?세팅 sql injection 방지
		st.setInt(1, num);

		// 5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = null;
		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

		}

		// 연결한 자원 해제
		rs.close();
		st.close();
		con.close();
		return departmentDTO;

	}

	// add
	public int add(DepartmentDTO departmentDTO) throws Exception {
		// 1,DB 연결
		Connection con = dbConnection.getConnection();
		// 2.SQL문 작성
		String stl = "INSERT INTO DEPARTMENTS " + " (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(stl);
		// 4. ?세팅 sql injection 방지
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());

		// 5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();

		// 6.자원해체
		st.close();
		con.close();

		return result;

	}

	// delete
	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String stl = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(stl);
		st.setInt(1, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

	// update
	public int update(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String stl = "UPDATE  DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(stl);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}
}

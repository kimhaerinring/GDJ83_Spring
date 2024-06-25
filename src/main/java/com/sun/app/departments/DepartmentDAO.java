package com.sun.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	@Autowired
	private DBConnection dbConnection;

	public void getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		// SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값을 세팅하는 단계

		// 최종 전송 및 결과를 처리 하는 단계
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			System.out.println(id + " : " + name);
		}
		// 연결한 자원을 해체
		rs.close();
		st.close();
		con.close();

	}

}

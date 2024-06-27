package com.sun.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.DBConnection;

@Repository
public class LocationDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<LocationDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();

		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();

			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));

			ar.add(locationDTO);

		}
		// 연결한 자원을 해체
		rs.close();
		st.close();
		con.close();
		return ar;

	}

	// detail가지고 오기
	public LocationDTO getDetail(int num) throws Exception {
		Connection con = dbConnection.getConnection();
		String stl = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=? ";

		PreparedStatement st = con.prepareStatement(stl);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();
		LocationDTO locationDTO = null;
		if (rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));

		}
		rs.close();
		st.close();
		con.close();
		return locationDTO;
	}

	// add
	public int add(LocationDTO locationDTO) throws Exception {
		// 1,DB 연결
		Connection con = dbConnection.getConnection();
		// 2.SQL문 작성
		String stl = "INSERT INTO LOCATIONS "
				+ " (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
				+ "VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(stl);
		// 4. ?세팅 sql injection 방지
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());

		// 5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();

		// 6.자원해체
		st.close();
		con.close();

		return result;

	}

	public int delete(LocationDTO locationDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String stl = "DELETE LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = con.prepareStatement(stl);
		st.setInt(1, locationDTO.getLocation_id());
		int result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

	public int update(LocationDTO locationDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String stl = "UPDATE  LOCATIONS SET STREET_ADDRESS=?, POSTAL_CODE=?, CITY=? ,STATE_PROVINCE=?,COUNTRY_ID=? WHERE LOCATION_ID=?";

		PreparedStatement st = con.prepareStatement(stl);
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		st.setInt(6, locationDTO.getLocation_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}

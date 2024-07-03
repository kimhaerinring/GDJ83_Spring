package com.sun.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		// SQL(Query)문 작성
		String sql = "SELECT * FROM PRODUCTS ORDER BY P_CODE ASC";

		// 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값을 세팅하는 단계

		// 최종 전송 및 결과를 처리 하는 단계
		ResultSet rs = st.executeQuery();
		List<ProductDTO> ar = new ArrayList<ProductDTO>();

		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setP_code(rs.getString("P_CODE"));
			productDTO.setAc_name(rs.getString("AC_NAME"));
			productDTO.setInterest(rs.getDouble("INTEREST"));
			productDTO.setScript(rs.getString("SCRIPT"));
			ar.add(productDTO);

		}
		// 연결한 자원을 해체
		rs.close();
		st.close();
		con.close();
		return ar;

	}

	public ProductDTO getDetail(String p_code) throws Exception {

		Connection con = dbConnection.getConnection();
		String stl = "SELECT * FROM PRODUCTS WHERE P_CODE=?";
		PreparedStatement st = con.prepareStatement(stl);

		st.setString(1, p_code);

		ResultSet rs = st.executeQuery();
		ProductDTO productDTO = null;

		if (rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setP_code(rs.getString("P_CODE"));
			productDTO.setAc_name(rs.getString("AC_NAME"));
			productDTO.setInterest(rs.getDouble("INTEREST"));
			productDTO.setScript(rs.getString("SCRIPT"));

		}

		// 연결한 자원 해제
		rs.close();
		st.close();
		con.close();
		return productDTO;

	}

	// add
	public int add(ProductDTO productDTO) throws Exception {
		// 1,DB 연결
		Connection con = dbConnection.getConnection();
		// 2.SQL문 작성
		String stl = "INSERT INTO PRODUCTS " + "VALUES (PRODUCTS_SEQ.NEXTVAL, ?,?, ?)";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(stl);
		// 4. ?세팅 sql injection 방지
		st.setString(1, productDTO.getAc_name());
		st.setDouble(2, productDTO.getInterest());
		st.setString(3, productDTO.getScript());

		// 5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();

		// 6.자원해체
		st.close();
		con.close();

		return result;

	}

	// delete
//	@RequestMapping("delete")
//	public String delete(Model model, ProductDTO productDTO) throws Exception {
//		int result = productService.delete(productDTO);
//		String url = "commons/message";
//		if (result > 0) {
//			url = "redirect:./list";
//		} else {
//			url = "commons/message";
//			model.addAttribute("result", "부서삭제에 실패하셨습니다");
//			model.addAttribute("url", "./list");
//		}
//		return url;
//	}

}

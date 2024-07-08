package com.sun.app.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {
	@Autowired
	private ProductDAO productDAO;

	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setP_code("56");
		productDTO = productDAO.getDetail(productDTO);
		// 단정문
		assertNotNull(productDTO);
	}

	@Test
	public void addTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setAc_name("네");
		productDTO.setInterest(0.3);
		productDTO.setScript("월50 적금");
		int result = productDAO.add(productDTO);
		assertEquals(1, result);
	}
}

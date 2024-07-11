package com.sun.app.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {
	@Autowired
	private ProductDAO productDAO;

	@Test
	public void addTest1() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		for (int i = 0; i < 100; i++) {
			productDTO.setAc_name("국민적금" + i);
			double r = ((int) (Math.random() * 1000)) / 100.0;
			productDTO.setInterest(r);
			productDTO.setScript("상세설명" + i);
			productDAO.add(productDTO);
			Thread.sleep(50); // 0.5초
		}
		System.out.println("finish");
	}

	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setP_code("56");
		productDTO = productDAO.getDetail(productDTO);
		// 단정문
		assertNotNull(productDTO);
	}

	public void addTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setAc_name("네");
		productDTO.setInterest(0.3);
		productDTO.setScript("월50 적금");
		int result = productDAO.add(productDTO);
		assertEquals(1, result);
	}
}

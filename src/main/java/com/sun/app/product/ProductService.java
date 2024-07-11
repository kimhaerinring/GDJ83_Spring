package com.sun.app.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Long page) throws Exception {
		// page가 1이면 첫번째 숫자는 1
		// 두번째숫자 10
		// page가 2라면 11 20
		// 3이라면 31 40
		if (page == null)
			page = 1L;
		Long perPage = 10L;
		Long startRow = (page - 1L) * perPage + 1L;
		Long lastRow = page * 10L;

		List<Long> ar = new ArrayList<Long>();
		ar.add(startRow);
		ar.add(lastRow);

		Long totalCount = productDAO.getTotalCount();
		Long totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		}
		System.out.println(totalPage);
		return productDAO.getList(ar);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}
}

package com.sun.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Pager pager) throws Exception {
		// page가 1이면 첫번째 숫자는 1
		// 두번째숫자 10
		// page가 2라면 11 20
		// 3이라면 31 40

		pager.makeRow();

		long totalCount = productDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return productDAO.getList(pager);
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

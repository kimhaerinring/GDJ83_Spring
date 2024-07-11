package com.sun.app.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public Map<String, Object> getList(Long page) throws Exception {
		// page가 1이면 첫번째 숫자는 1
		// 두번째숫자 10
		// page가 2라면 11 20
		// 3이라면 31 40
		// 0. DB 에서 일정한 갯수 조회
		if (page == null)
			page = 1L;
		long perPage = 10L;
		long startRow = (page - 1L) * perPage + 1L;
		long lastRow = page * 10L;

		List<Long> ar = new ArrayList<Long>();
		ar.add(startRow);
		ar.add(lastRow);
		// 1. 총 개수로 총 페이지 수 구하기
		long totalCount = productDAO.getTotalCount();
		long totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		}
		// 2.총 페이지 수로 총 블럭수 구하기
		long perBlock = 5L; // 한페이지에 보여질 페이지번호의 갯수
		long totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}
		// 3. 현재 페이지 번호로 현재 블럭 번호 구하기
		long curBlock = 0;
		curBlock = page / perBlock;
		if (page % perBlock != 0) {
			curBlock++;
		}
		// 4. 현재 블럭 번호로 시작 번호와 끝 번호 구하기
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = perBlock * curBlock;

		// 5. 이전, 다음 블럭 유무 판단
		boolean pre = true;
		boolean next = true;
		if (curBlock == 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {
			next = false;
			lastNum = totalPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", productDAO.getList(ar));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);

		return map;
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

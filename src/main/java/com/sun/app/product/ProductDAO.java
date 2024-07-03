package com.sun.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sun.app.product.ProductDAO.";

	public List<ProductDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList");

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}
}

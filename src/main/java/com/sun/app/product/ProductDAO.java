package com.sun.app.product;

import java.util.List;
import com.sun.app.product.ProductFileDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.Pager;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sun.app.product.ProductDAO.";

	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}
	public String getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}
	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}
	public int addFile(ProductFileDTO productFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", productFileDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}
}

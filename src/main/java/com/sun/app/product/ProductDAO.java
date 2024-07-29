package com.sun.app.product;

import java.util.List;
import java.util.Map;

import com.sun.app.boards.qnas.QnaDTO;
import com.sun.app.member.MemberDTO;
import com.sun.app.product.ProductFileDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.sun.app.util.Pager;
import com.sun.app.util.ProductCommentPager;
@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sun.app.product.ProductDAO.";
	
	public int commentUpdate(ProductCommentsDTO productCommentsDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "commentUpdate", productCommentsDTO);
	}
	
	
	public int commentDelete(ProductCommentsDTO productCommentsDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "commentDelete", productCommentsDTO);
	}
public int addWish(Map<String,Object>map)throws Exception {
	return sqlSession.insert(NAMESPACE + "addWish", map);
}	
public int deleteWishList(Map<String,Object>map) throws Exception {
	return sqlSession.delete(NAMESPACE + "deleteWishList", map);
}
public List<ProductDTO> wishList(MemberDTO memberDTO)throws Exception {
	return sqlSession.selectList(NAMESPACE + "wishList", memberDTO);
}	
public List<ProductCommentsDTO> commentList(ProductCommentPager productCommentPager)throws Exception {
	return sqlSession.selectList(NAMESPACE + "commentList", productCommentPager);
}	
public Long commentTotalCount(ProductCommentPager productCommentPager) throws Exception {
	return sqlSession.selectOne(NAMESPACE + "commentTotalCount", productCommentPager);
}
public Long getTotalCount(ProductCommentPager productCommentPager) throws Exception {
	return sqlSession.selectOne(NAMESPACE + "getTotalCount", productCommentPager);
}
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
	public int commentAdd(ProductCommentsDTO productCommentsDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "commentAdd", productCommentsDTO);
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

package com.sun.app.product;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.tools.ForwardingJavaFileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sun.app.member.MemberDTO;
import com.sun.app.files.FileManager;
import com.sun.app.product.ProductFileDTO;
import com.sun.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FileManager fileManager;
	
	public int addWish(String p_code, String id)throws Exception {
		Map<String,Object>map =new HashMap<String, Object>();
		map.put("p_code", p_code);
		map.put("id", id);
	return	productDAO.addWish(map);
	}
	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return productDAO.wishList(memberDTO);
	}
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

	public int add(ProductDTO productDTO, HttpSession session, MultipartFile[] files) throws Exception {
		String num=productDAO.getNum();
		productDTO.setP_code(num);
		int result = productDAO.add(productDTO);
		
		if (files == null) {
			return result;
		}
		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");
//		File file = new File(path);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
		// 2. 폴더의 저장할 파일명 생성
		for (MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName =fileManager.fileSave(path,f);
			//4. 파일 정보를 DB 에서장
			//파일명, 오리지널, 파일번호
			ProductFileDTO productFileDTO =new ProductFileDTO();
			productFileDTO.setFilename(fileName);
			productFileDTO.setOriname(f.getOriginalFilename());
			productFileDTO.setP_code(num);
			System.out.println(productFileDTO);
			result = productDAO.addFile(productFileDTO);
		}
		return result;

	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}
}

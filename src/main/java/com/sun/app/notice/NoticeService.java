package com.sun.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.app.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public Map<String, Object> getList(Long page, String kind, String search) throws Exception {
		if (page == null) {
			page = 1L;
		}
		if (page < 1) {
			page = 1L;
		}
		if (search == null) {
			search = "";
		}
		long perPage = 10L;
		long startRow = (page - 1L) * perPage + 1L;
		long lastRow = page * 10L;
		Pager pager = new Pager();
		pager.setStartNum(startRow);
		pager.setLastNum(lastRow);
		pager.setKind(kind);
		pager.setSearch(search);
		// 1.총개수를 이용해서 총 페이지 수 구하기
		long totalCount = noticeDAO.getTotalCount(pager);
		long totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		}
		// 2. 총 페이지 수로 총 블럭 수 구하기
		long perBlock = 5L;// 한페이지에 보여질 페이지번호의 갯수
		long totalBlock = totalPage / perBlock; // 총 블럭의 수
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}
		// 3. 현재 페이지 번호로 현재 블럭 번호를 구하기

		// page 1 2 3 4 5 6 7 10 11
		// 블럭 번호 1 1 1 1 1 2 2 2 3
		long curBlock = 0;
		curBlock = page / perBlock;
		if (page % perBlock != 0) {
			curBlock++;
		}
		// 4.현재 블럭 번호로 시작 번호와 끝번호를 구한다
		// curBlock 1 2 3 4 5 6 7 8 9 10
		// startnum 1 6 11 16 21 26
		// lastnum 5 10 15 20 25 30
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = perBlock * curBlock;

		// 5. 이전블럭 다음 블럭 유무 판단
		boolean pre = true; // true면 이전 블럭이 존재, false면 이전 블럭이 x
		boolean next = true; // true면 이전 블럭이 존재, false면 이전 블럭이 x
		if (curBlock == 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {
			next = false;
			lastNum = totalPage; // 마지막 페이지 수
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", noticeDAO.getList(pager));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		map.put("search", search);
		map.put("kind", kind);
		return map;
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
}

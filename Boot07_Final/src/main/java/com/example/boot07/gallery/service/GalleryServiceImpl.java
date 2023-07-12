package com.example.boot07.gallery.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.boot07.exception.NotDeleteException;
import com.example.boot07.gallery.dao.GalleryDao;
import com.example.boot07.gallery.dto.GalleryDto;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryDao dao;

	@Override
	public void getList(HttpServletRequest request) {
		// 한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT = 12;
		// 하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT = 5;

		// 보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum = 1;
		// 페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		// 만일 페이지 번호가 파라미터로 넘어 온다면
		if (strPageNum != null) {
			// 숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum = Integer.parseInt(strPageNum);
		}

		// 보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;

		// startRowNum 과 endRowNum 을 GalleryDto 객체에 담고
		GalleryDto dto = new GalleryDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		List<GalleryDto> list = dao.getList(dto);

		// 하단 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;

		// 전체 row 의 갯수
		int totalRow = dao.getCount();
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if (endPageNum > totalPageCount) {
			endPageNum = totalPageCount; // 보정해 준다.
		}

		// request 영역에 담아주기
		request.setAttribute("list", list); // gallery list
		request.setAttribute("startPageNum", startPageNum); // 시작 페이지 번호
		request.setAttribute("endPageNum", endPageNum); // 끝 페이지 번호
		request.setAttribute("pageNum", pageNum); // 현재 페이지 번호
		request.setAttribute("totalPageCount", totalPageCount); // 모든 페이지 count

	}

	@Override
	public void insert(HttpServletRequest request, GalleryDto dto) {
		// 업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값 얻어오기
		if (dto.getImage().isEmpty()) {
			throw new NotDeleteException("사진이 없어요");
		}
		MultipartFile myFile = dto.getImage();
		// 원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		// 파일의 크기 나중에 다운로드도 만들거니까 일단 냅둠
		long fileSize = myFile.getSize();

		// webapp/resources/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
		String realPath = request.getServletContext().getRealPath("/resources/upload");
		// 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		// 디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if (!upload.exists()) {// 만일 디렉토리가 존재하지 않으면
			upload.mkdir(); // 만들어 준다.
		}
		// 저장할 파일 명을 구성한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		try {
			// upload 폴더에 파일을 저장한다.
			myFile.transferTo(new File(filePath + saveFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// dto엔 caption이랑 multiPartFile 이 들어있다
		// dto 나머지 필요한 정보 담는다
		String id = (String) request.getSession().getAttribute("id");
		dto.setWriter(id);
		dto.setImagePath("/resources/upload/" + saveFileName);
		System.out.println(dto.getWriter());
		System.out.println(dto.getImagePath());
		System.out.println(dto.getCaption());
		// fileDao 를 이용해서 DB 에 저장하기
		dao.insert(dto);
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}

	@Override
	public void select(ModelAndView mView, int num) {
		mView.addObject("dto", dao.getData(num));
	}

}

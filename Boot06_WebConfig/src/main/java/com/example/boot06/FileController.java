package com.example.boot06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@Value("${file.location}")
	private String fileLocation;

	@GetMapping("/file/uploadform")
	public String uploadform() {
		return ("file/uploadform");

	}

	@PostMapping("/file/upload")
	public String upload(FileDto dto, Model model) {
		MultipartFile myFile = dto.getMyFile();
		String orgFileName = myFile.getOriginalFilename();
		String realPath = fileLocation;
		String saveFileName = UUID.randomUUID().toString();

		String filePath = realPath + File.separator + saveFileName;
		try {
			myFile.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("orgFileName", orgFileName);
		model.addAttribute("saveFileName", saveFileName);
		model.addAttribute("fileSize", myFile.getSize());
		return "file/upload";
	}

	@GetMapping("file/download")
	public ResponseEntity<InputStreamResource> download(String orgFileName, String saveFileName, long fileSize)
			throws UnsupportedEncodingException, FileNotFoundException {

		String encodedName = URLEncoder.encode(orgFileName, "utf-8");
		encodedName = encodedName.replaceAll("\\+", " ");
		// 응답 헤더 (스프링에서 제공해주는 클래스) (웹브라우저에 알릴 정보)
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
		// 파일 이름 정보 (웹브라우저가 이를 이용해서 파일 만들어줌)
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + encodedName);
		headers.setContentLength(fileSize);

		// 읽을 파일 경로 구성
		String filePath = fileLocation + File.separator + saveFileName;
		// 파일에서 읽어들일 스트림 객체
		InputStream is = new FileInputStream(filePath);

		return ResponseEntity.ok().headers(headers).header("content-Transfer-Encoding", "binary")
				.body(new InputStreamResource(is));

	}

}

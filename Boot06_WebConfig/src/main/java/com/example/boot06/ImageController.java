package com.example.boot06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	// application.properties 파일에 있는 정보 얻어내기
	@Value("${file.location}")
	private String fileLocation;

	@GetMapping(value = "/image/{imageName}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	@ResponseBody
	public byte[] getImage(@PathVariable("imageName") String imageName) throws IOException {
		// imageName엔 응답해줄 이미지의 이름이 들어있다.

		// 읽을 파일 경로
		// fileLocation = application.properties 에 지정
		//
		String absolutePath = fileLocation + File.separator + imageName;
		// 파일 읽을 InputStream
		InputStream is = new FileInputStream(absolutePath);

		// fileLocation 필드에는 파일이 저장되어 있는 서버의 파일 시스템상에서의 위치가 들어있다.

		return IOUtils.toByteArray(is);
	}
}

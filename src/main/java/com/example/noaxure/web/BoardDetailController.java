package com.example.noaxure.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noaxure.service.BoardDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("boarddetail")
@Slf4j
@RequiredArgsConstructor
public class BoardDetailController {
	private final BoardDetailService boardDetailService;

//	@GetMapping("/{id}")
//	public ResponseEntity<ResultData> getimage(@PathVariable int id){
//		BoardDetail dto = boardDetailService.get(id);
//		return ResultData.ok(dto);
//	}


	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> getContentBoardfileData(@PathVariable int id) {
		byte[] fileData = boardDetailService.getContentBoardfileData(id).getImage();

		return ResponseEntity.ok()
	            .contentType(MediaType.IMAGE_JPEG) // 이미지 타입에 따라 수정
	            .body(fileData);

//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.IMAGE_JPEG);

//		try {
//			File imageFile = createImageFile(fileData);
//			System.out.println(imageFile);
//			return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
//		} catch(IOException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		}
	}
//	이미지 업로드용 안쓸꺼임 이제
//	@PutMapping("/imageUpdate")
//    public ResponseEntity<ResultData> imageUpdate(@RequestBody byte[] imageContent){
//		BoardDetailRequestDto dto = new BoardDetailRequestDto();
//		dto.setId(8);
//		dto.setImage(imageContent);
//		System.out.println(dto.getImage().length);
//		int result = boardDetailService.update(dto);
//
//		return ResultData.ok(result);
//	}
//
}

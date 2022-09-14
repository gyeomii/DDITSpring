package com.spring.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.command.FileUploadCommand;

@Controller
public class FileUploadController {
	//들어오는 url과 page의 url이 같으면 url을 return하지않아도 된다.
	@GetMapping("/fileUploadForm")
	public void fileUpload() {}
	
	//파일 저장 폴더 설정
	private String uploadPath = "c:/spring/fileupload/".replace("/", File.separator);
	
	//후처리 비동기방식일때 유용
	@PostMapping(value="/multipartFile", produces="text/plain;charset=utf-8")
	public String uploadByMultipartFile(String title, MultipartFile file, Model model) throws Exception{
		String url="fileUploaded";
		
		File saveFile = new File(uploadPath, file.getOriginalFilename());
		
		saveFile.mkdirs();
		/*파일저장*/
		file.transferTo(saveFile);
		
		model.addAttribute("title", title);
		model.addAttribute("originalFileName", file.getOriginalFilename());
		model.addAttribute("uploadedFileName", saveFile.getName());
		model.addAttribute("uploadPath", saveFile.getAbsolutePath());
		
		return url;
	}
	
	@PostMapping(value="/multipartHttpServletRequest", produces="text/plain;charset=utf-8")
	public String uploadByMultipartHttpServletRequest(MultipartHttpServletRequest request, Model model) throws Exception{
		String url=null;
		
		String title = request.getParameter("title");
		MultipartFile multi = request.getFile("file");
		
		url = uploadByMultipartFile(title, multi, model);
		
		return url;
	}
	//한번에 여러파일 받을 때 유용
	@PostMapping(value="/commandObject", produces="text/plain;charset=utf-8")
	public String uploadByCommandObject(FileUploadCommand command, Model model) throws Exception{
		String url=null;
		
		url = uploadByMultipartFile(command.getTitle(), command.getFile(), model);
		
		return url;
	}
	
}

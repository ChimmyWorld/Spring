package com.itbank.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.vo.FileDAO;
import com.itbank.model.vo.FileVO;

@Service
public class FileService {

	@Autowired
	private FileDAO dao;
	
	@Value("file:E:/springUpload/")
	private Resource rs;
	
	public File[] getDir() throws IOException {
		File dir = rs.getFile();
		
//		System.out.println("존재여부?" + dir.exists());
//		System.out.println("파일인가?" + dir.isFile());
//		System.out.println("폴더인가?" + dir.isDirectory() + "\n");
		
		if (dir.exists() == false) { // 존재하지 않으면
			dir.mkdir();			 // 폴더를 생성
		}
		
		return dir.listFiles();
	}

	public void fileUpload(MultipartFile upload) throws IOException {
		File dest = new File(rs.getFile(), upload.getOriginalFilename());
		upload.transferTo(dest);
	}
	
	public void fileUpload(MultipartFile upload, String name) throws IOException {
		String oName = upload.getOriginalFilename();
		String ext = oName.substring(oName.lastIndexOf("."));
		
		name = ("".equals(name)) ? oName : name + ext;
		// input에서 값을 작성하지 않고 보내면 null이 아닌 빈 문자열이 들어감
		
		File dest = new File(rs.getFile(), name);	
		upload.transferTo(dest);
	}

	public void fileUpload(FileVO input) throws IOException {
		MultipartFile file = input.getUpload();
		
		input.setPath(rs.getFilename());
		input.setName(file.getOriginalFilename());
		
		dao.insert(input);
	}

}

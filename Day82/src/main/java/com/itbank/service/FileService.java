package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.FileDAO;
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
		
		//1. DB에 전달할 값을 분할
		input.setPath(rs.getFile().toString());
		input.setName(file.getOriginalFilename());
		
		//2. 실제 위치에 업로드 진행
		File dest = new File(rs.getFile(), file.getOriginalFilename());
		file.transferTo(dest);
		
		// DB 정보 등록
		dao.insert(input);
	}

	public List<FileVO> getFiles() {
		return dao.selectAll();
	}
	
	public FileVO getFile(int idx) {
		return dao.selectOne(idx);
	}

	public int delFile(FileVO input) throws IOException {
		String name = input.getName();
		File file = new File(rs.getFile(), name);
		
		if (file.exists()) {
			file.delete();
		}
		
		return dao.delete(input.getIdx());
	}

	public int updateFile(FileVO input) throws IOException {	
		//원본, 대상
		FileVO file = dao.selectOne(input.getIdx());
		
		File src = new File(rs.getFile(), file.getName());
		File dst = new File(rs.getFile(), input.getName());
		
		System.out.println(src);
		System.out.println(dst);
		
		src.renameTo(dst);
		
		return dao.update(input);
		
	}

}

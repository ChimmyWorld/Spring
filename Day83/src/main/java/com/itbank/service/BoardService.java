package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.BoardDAO;
import com.itbank.model.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	@Value("file:E:/boardImg/")
	private Resource dir;

	public String test() {
		return dao.test();
	}

	public BoardVO getBoard(int idx) {
		return dao.selectOne(idx);
	}

	public List<BoardVO> getBoards() {
		return dao.selectAll();
	}

	public int addBoard(BoardVO input) throws IOException {
		// 1. DB에 저장할 파일 이름 저장
		MultipartFile file = input.getUpload();
		input.setImg(file.getOriginalFilename());
		
		// 2. insert 후 작성된 글 번호(idx) 가져오기
		int row = dao.insert(input);
		String idx = dao.selectIdx();
		
		// 3. 해당 번호의 폴더를 생성
		File newDir = new File(dir.getFile(), idx);
		newDir.mkdir();
		
		// 4. 3번의 폴더에 이미지를 업로드
		File dst = new File(newDir , file.getOriginalFilename());
		file.transferTo(dst);
		
		return row;
	}

	public int deleteBoard(int idx) throws IOException {
		File delDir = new File(dir.getFile(), Integer.toString(idx));
		
		// 해당 디렉토리의 파일들을 반복으로 가져온다
		for (File file : delDir.listFiles()) {
			file.delete();	// 가져온 파일을 제거
		}
		
		delDir.delete();	// 디렉토리가 비면 제거
							// (디렉토리는 empty가 되어야 삭제가 가능하기 때문)

		return dao.delete(idx);
	}

	public int updateBoard(BoardVO input) throws IOException {
		// 1. DAO에 전달할 파일명(img) 지정
		MultipartFile file = input.getUpload();
		input.setImg(file.getOriginalFilename());
		
		// 2. 수정할 게시글 이미지 경로를 지정
		int idx = input.getIdx();
		File files = new File(dir.getFile(), Integer.toString(idx));
		File dst = new File(files, file.getOriginalFilename());
		
		// 3. 해당 폴더 안의 파일 모두를 제거
		for (File f: files.listFiles()) {
			f.delete();
		}
		
		// 4. 수정할 파일을 업로드
		file.transferTo(dst);
		
		return dao.update(input);
	}

}

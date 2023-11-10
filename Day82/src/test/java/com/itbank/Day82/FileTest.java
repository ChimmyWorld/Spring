package com.itbank.Day82;

import java.io.File;

import org.junit.Test;

public class FileTest {
	
	@Test
	public void ex01() {
		File dir = new File("E:\\springUpload");
		System.out.println("파일 존재 여부? " + dir.exists());
		
		// 지정 폴더 안 파일 목록
		for (File file : dir.listFiles()) {
			System.out.println(file);
		}
		
		// 폴더에서 파일 하나 지정
		File file = new File(dir, "profile.jpg");
		
		System.out.println("파일 존재 여부?" + file.exists());
		
		// 삭제 후 확인
		if (file.exists()) {
			file.delete();
		}
		System.out.println("파일 존재 여부?" + file.exists());
		
		// 다른 파일을 지정
		file = new File(dir, "test.jar");
		File dest = new File(dir, "change.jar");
		
		System.out.println("file 존재? " + file.exists());
		System.out.println("dest 존재? " + dest.exists());
				
		file.renameTo(dest);
		System.out.println("file 존재? " + file.exists());
		System.out.println("dest 존재? " + dest.exists());
		
	}
}

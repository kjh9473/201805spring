package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.file.util.FileUtil;

public class FileUtilTest {
	
	private Logger logger = LoggerFactory.getLogger(FileUtilTest.class);
	
	//테스트 코드를 운영코드보다 먼저 작성하는 방법
	//Test Driven Development (TDD)
	/**
	* Method : fileUtilTest
	* 작성자 : pc25
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 있는 경우)
	*/
	@Test
	public void fileUtilTest() {
		/***Given***/
		String fileName = "sally.png";
		
		String value = FileUtil.getFileExt(fileName);
		
		/***When***/
		
		/***Then***/
		assertEquals(".png",value);

	}
	
	/**
	* Method : fileUtilTest2
	* 작성자 : pc25
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 없는 경우)
	*/
	@Test
	public void fileUtilTest2() {
		/***Given***/
		String fileName = "sally";
		
		/***When***/
		String value = FileUtil.getFileExt(fileName);
		
		/***Then***/
		assertEquals("",value);

	}
	
	/**
	* Method : fileUtilTest3
	* 작성자 : pc25
	* 변경이력 :
	* Method 설명 : 파일 확장자 추출(확장자가 있는경우,파일명에 점이 들어가는 경우)
	*/
	@Test
	public void fileUtilTest3() {
		/***Given***/
		String fileName = "sally.brown.png";
		
		/***When***/
		String value = FileUtil.getFileExt(fileName);
		
		/***Then***/
		assertEquals(".png",value);

	}

}

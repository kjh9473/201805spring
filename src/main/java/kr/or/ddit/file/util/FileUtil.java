package kr.or.ddit.file.util;

public class FileUtil {
	
	/**
	* Method : getFileExt
	* 작성자 : pc25
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 :파일 확장자 추출
	*/
	public static String getFileExt(String fileName) {
		int chk = fileName.lastIndexOf(".");
		String value = "";
		
		if (chk == -1) {
			value = "";
		}else {
			value = fileName.substring(fileName.lastIndexOf("."));
		}
		return value;
	}
	
	
}

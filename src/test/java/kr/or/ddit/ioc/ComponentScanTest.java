package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-scan.xml"})
public class ComponentScanTest {
	
	private Logger logger = LoggerFactory.getLogger(ComponentScanTest.class);
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	/**
	* Method : componentScanTest
	* 작성자 : pc25
	* 변경이력 :
	* Method 설명 : spring annotation scan을 통해 스프링 빈 생성이 정상적으로 되었는지 테스트
	*/
	@Test
	public void boardDaoTest() {
		/***Given***/
		

		/***When***/
		List<BoardVo> boardList = boardDao.selectBoardList();
		
		for(BoardVo boardVo : boardList) {
			logger.debug("{}",boardVo);
		}
		
		boardList = boardService.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("{}",boardVo);
		}
		/***Then***/
		assertNotNull(boardDao);
		

	}
	
	@Test
	public void boardServiceTest() {
		/***Given***/
		

		/***When***/
		List<BoardVo>boardList = boardService.selectBoardList();
		
		for(BoardVo boardVo : boardList) {
			logger.debug("{}",boardVo);
		}
		
		/***Then***/
		assertNotNull(boardService);
	}
	
	@Test
	public void boardTest() {
		/***Given***/
		

		/***When***/
		
		/***Then***/
		assertEquals(true,boardDao==boardService.getBoardDao());

	}

}
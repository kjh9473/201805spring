package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Service("userService")
public class UserService implements UserServiceInf {
	
	@Resource(name="userDao")
	UserDaoInf dao;
	
	@Override
	public List<UserVo> selectUserAll() {
		// TODO Auto-generated method stub
		return dao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		// TODO Auto-generated method stub
		return dao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return dao.selectUser(userVo);
	}

	
	/**
	* Method : selectUserPageList
	* 작성자 : pc25
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	@Override
	public Map<String,Object> selectUserPageList(PageVo pageVo) {
		//페이지에 해당하는 유저 리스트(1~10건사이)
		List<UserVo> userList = dao.selectUserPageList(pageVo);
		
		//페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = dao.getUserCnt();
		
		//결과를 담는 Map
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList",userList);
		resultMap.put("pageCnt",(int)Math.ceil((double)totalUserCnt/pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int getUserCnt() {
		// TODO Auto-generated method stub
		return dao.getUserCnt();
	}
	/**
	* Method : insertUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return dao.insertUser(userVo);
	}
	/**
	* Method : deleteUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return dao.deleteUser(userId);
	}
	
	/**
	* Method : updateUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보수정
	*/
	public int updateUser(UserVo userVo){
		// TODO Auto-generated method stub
		return dao.updateUser(userVo);
	};
	
}

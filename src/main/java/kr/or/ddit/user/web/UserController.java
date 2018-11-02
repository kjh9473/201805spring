package kr.or.ddit.user.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;


@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/loginView")
	public String loginView() {
		
		return "login/login";
	}
	
	@RequestMapping(value="/loginProcess",method= RequestMethod.POST)
	public String loginProcess(UserVo userVo,Model model) {
		
		if(userVo.getUserId().equals("brown")&&userVo.getPass().equals("brownpass")) {
			model.addAttribute("userVo",userVo);
			
			return "main";
		}else {
			return "login/login";
		}
		
		
	}

}

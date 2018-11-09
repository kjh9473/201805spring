package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kr.or.ddit.mvc.view.TimesTablesView;

@Controller
public class CustomViewController {
	
//	@ModelAttribute
//	public void modelAttribute(Model model) {
//		model.addAttribute("tables",7);
//	}
	
	@RequestMapping("/customView")
	public View customView() {
		return new TimesTablesView();
	}
	
	@RequestMapping("/customViewBeanName")
	public String customViewBeanName(@RequestParam(name="tables",defaultValue="3")int tables,Model model) {
		model.addAttribute("tables",tables);
		return "timesTablesView";
	}
	
}

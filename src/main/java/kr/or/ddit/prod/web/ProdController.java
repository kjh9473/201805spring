package kr.or.ddit.prod.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVo;


@RequestMapping("/prod")
@Controller
public class ProdController {
	
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@RequestMapping("/prodPageList")
	public String prodPageList(PageVo pageVo,Model model) {
		
		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		
		model.addAllAttributes(resultMap);
		
		return "prod/prodPagingList";
	}
	
	@RequestMapping("/ajaxProdPageList")
	public String prodPageListAjax(PageVo pageVo,Model model) {
		
		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "jsonView";
	}
	
	@RequestMapping("/prodPagiListAjaxHtml")
	public String userPagiListAjaxHtml(Model model,PageVo pageVo) {
		Map<String,Object> resultMap = prodService.selectProdPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "prod/pagiListHtml";
	}
	
	@RequestMapping("/getProdPaginationHtml")
	public String getProdPaginationHtml(Model model,PageVo pageVo) {
		Map<String,Object> resultMap = prodService.selectProdPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "prod/paginationHtml";
	}
	
	@RequestMapping("/prodDetail")
	public String prodDetail(@RequestParam("prod_Id")String prod_id,Model model) {
		
		ProdVo prodVo = prodService.selectProdDetail(prod_id);
		
		model.addAttribute("prodVo",prodVo);
		
		return "prod/prodDetail";
	}
	
	@RequestMapping("/prodPageListAjax")
	public String prodPageListAjax(Model model,PageVo pageVo) {
		Map<String,Object> resultMap = prodService.selectProdPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "jsonView";
	}
	
	
}

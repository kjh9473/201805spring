<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<li><a href="javascript:getUserListHtml(1);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li> 
<c:forEach begin="1" end="${pageCnt }" var="i">
		<li><a href="javascript:getUserListHtml(${i });">${i }</a>
</c:forEach>
<li><a href="javascript:getUserListHtml(${pageCnt });"	aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
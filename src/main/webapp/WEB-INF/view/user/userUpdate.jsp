<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- jquery ui css -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- daum주소 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	//주소 검색 버튼 클릭이벤트가 발생 했을때 실행
	$(document).ready(function() {

		//생일 input datepicker 적용
		$("#birth").datepicker({
			dateFormat : "yy-mm-dd",
			yearRange : "1995:2018",
			changeMonth : true,
			changeYear : true
		});
		//주소 검색 버튼 이벤트 핸들러
		$("#addrSearchBtn").click(function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					console.log(data);
					//주소 : roadAddress
					//상세주소 :  ""
					//우편번호 : zonecode

					//주소 input value설정 : data.roadAddress
					//우편번호 input value설정 : data.zonecode
					$("#addr1").val(data.roadAddress);
					$("#zipcd").val(data.zonecode);
				}
			}).open();
		});
	});
</script>
<form action="/user/userUpdate" method="post" class="form-horizontal"
	role="form" enctype="multipart/form-data">


	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<img alt="" src="${userVo.profile }" width="200" height="200">
			<input type="file" name="profilePic"><br>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userId" name="userId"
				placeholder="사용자 아이디" value="${userVo.userId }" readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pass" name="pass"
				placeholder="패스워드" value="${userVo.pass }">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name"
				placeholder="사용자 이름" value="${userVo.name}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr1" name="addr1"
				placeholder="주소" readonly value="${userVo.addr1}"> <br>
			<button id="addrSearchBtn" type="button" class="btn btn-default">주소검색</button>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr2" name="addr2"
				placeholder="상세주소" value="${userVo.addr2}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="zipcd" name="zipcd"
				placeholder="우편번호" readonly value="${userVo.zipcd}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">생년월일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="birth" name="birth"
				placeholder="생년월일"
				value="<fmt:formatDate value="${userVo.birth}" pattern="yyyy-MM-dd" />">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이메일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email" name="email"
				placeholder="이메일" value="${userVo.email }">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">연락처</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="tel" name="tel"
				placeholder="연락처" value="${userVo.tel }">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">수정하기</button>
		</div>
	</div>
</form>

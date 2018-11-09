<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
.prodClick {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	// 교수님 방법
	$(document).ready(function() {
		var ev = "click";
		$("#prodList").on(ev, ".prodClick", function() {
			console.log("prodClick");
			var prod_id = $(this).children()[1].innerHTML; // userId 구하기

			$("#prod_Id").val(prod_id);
			$("#frm").submit();
		});
		getProdList(1);
		// 		getProdListHtml(1);
		// 		getProdPaginationHtml(1);
	});

	function getProdListHtml(page) {
		var pageSize = 10;

		$.ajax({
			url : "/prod/prodPagiListAjaxHtml",
			type : "get",
			data : "page=" + page + "&pageSize=" + pageSize,
			success : function(dt) {
				console.log(dt);
				$("#prodList").html(dt);
			}
		});
	}

	function getProdPaginationHtml(page) {
		var pageSize = 10;

		$.ajax({
			url : "/prod/getProdPaginationHtml",
			type : "get",
			data : "page=" + page + "&pageSize=" + pageSize,
			success : function(dt) {
				console.log(dt);
				$(".pagination").html(dt);
			}
		});
	}

	function getProdList(page) {
		var pageSize = 10;
		console.log("page : " + page);

		//ajax call
		//사용자 리스트 데이터만 가져오기
		//html(기존) --> json(to-be) 데이터를 받는 형태로 변경
		$.ajax({
					type : "GET",
					url : "/prod/ajaxProdPageList",
					data : "page=" + page + "&pageSize=" + pageSize,
					success : function(data) {
						var html = "";
						$.each(data.prodList, function(idx, prod) {
							html += "<tr class='prodClick'>";
							html += "<td>" + prod.rnum + "</td>";
							html += "<td>" + prod.prod_id + "</td>";
							html += "<td>" + prod.prod_name+ "</td>";
							html += "<td>" + prod.lprod_nm + "</td>";
							html += "<td>" + prod.prod_insdate2 + "</td>";
							html += "</tr>";
						});

						$("#prodList").html("");
						$("#prodList").html(html);

						var page = "";
						page += "<li><a href=\"javascript:getProdList(1);\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>";
						for (var i = 1; i <= data.pageCnt; i++) {
							page += "<li><a href=\"javascript:getProdList(" + i
									+ ");\">" + i + "</a>";
						}
						page += "<li><a href=\"javascript:getProdList("
								+ data.pageCnt
								+ ");\"aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span></a></li>";
						$(".pagination").html("");
						$(".pagination").html(page);

					}
				});
	}
</script>

<form action="/prod/prodDetail" method="get" id="frm">
	<input type="hidden" id="prod_Id" name="prod_Id" />
</form>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">제품</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="tableId">
				<thead>
					<tr>
						<th>번호</th>
						<th>제품 아이디</th>
						<th>제품명</th>
						<th>제품그룹명</th>
						<th>제품등록일</th>
					</tr>
				</thead>
				<!-- userList loop -->

				<tbody id="prodList">
					<%-- 					<c:forEach items="${prodList }" var="vo"> --%>
					<!-- 						<tr class="prodClick"> -->
					<%-- 							<td>${vo.rnum }</td> --%>
					<%-- 							<td>${vo.prod_id }</td> --%>
					<%-- 							<td>${vo.prod_name }</td> --%>
					<%-- 							<td>${vo.lprod_nm }</td> --%>
					<%-- 							<td><fmt:formatDate value="${vo.prod_insdate }" --%>
					<%--  									pattern="yyyy-MM-dd" /></td>  --%>
					<!-- 						</tr> -->
					<%-- 					</c:forEach> --%>
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="/userForm">제품 등록</a>
		<div class="text-center">
			<ul class="pagination">
				<%-- 				<li><a href="/prodPageList?page=<%=1%>&pageSize=10" --%>
				<!-- 					aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
				<!-- 				</a></li> -->

				<%-- 				<c:forEach begin="0" end="${pageCnt-1 }" var="i"> --%>
				<%-- 														<c:if test="${i<5 }"> --%>
				<%-- 					<li><a href="/prodPageList?page=${i+1 }&pageSize=10">${i+1 }</a> --%>
				<%-- 															</c:if> --%>
				<%-- 				</c:forEach> --%>
				<%-- 				<li><a href="/prodPageList?page=${pageCnt }&pageSize=10" --%>
				<!-- 					aria-label="Next"> <span aria-hidden="true">&raquo;</span> -->
				<!-- 				</a></li> -->
			</ul>
		</div>
	</div>
</div>
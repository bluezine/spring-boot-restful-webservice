<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.1.3.min.js' />"></script>
<link rel="stylesheet" href="<c:url value='resources/bootstrap/css/bootstrap-theme.min.css' />" />
<link rel="stylesheet" href="<c:url value='resources/bootstrap/css/bootstrap.min.css' />" />
<script type="text/javascript">
	$(document).ready(function() {
		
	})
	
	function del(id) {
		$.ajax({
			 url: "<c:url value='/' />"
			,method: "delete"
			,data: JSON.stringify({"id":id})
			,contentType : "application/json"
			,success: function() {
				$("#" + id + "_line").remove();
			}
			,error: function() {
				alert('에러');
			}
		})
	}
	
	function modify(id, name) {
		$("#modify_id").val(id);
		$("#modify_name").val(name);
	}
	
	function modifyAction() {
		$.ajax({
			 url: "<c:url value='/' />"
			,method: "put"
			,dataType: "json"
			,data: JSON.stringify({"id":$("#modify_id").val(), "name":$("#modify_name").val()})
			,contentType: "application/json"
			,success: function(data) {
				$("#" + data.id +"_name").html(data.name);
				$("#modify_id").val();
				$("#modify_name").val();
			}
		})
	}
	
	function insert() {
		$.ajax({
			 url: "<c:url value='/' />"
			,method: "post"
			,dataType: "json"
			,data: JSON.stringify({"id":$("#insert_id").val(), "name":$("#insert_name").val()})
			,contentType: "application/json"
			,success: function(data) {
				$("#tableContent").append("<tr id=\""+data.id+"_line\">"+
						"<td id=\""+data.id+"_id\">" + data.id + "</td>"+
						"<td id=\""+data.id+"_name\">" + data.name + "</td>"+
						"<td><button role=\"button\" class=\"btn btn-danger\" onclick=\"javascript:del('"+data.id+"')\">삭제</button>" +
						"<button role=\"button\" class=\"btn btn-primary\" onclick=\"javascript:modify('"+data.id+"', '"+data.name+"')\">수정</button></td>" +
						"</tr>");
			}
		})
	}
</script>
</head>
<body>
	<table class="table table-bordered" id="tableContent">
		<tr>
			<th class="col-lg-4 col-sm-4">ID</th><th class="col-lg-4 col-sm-4">NAME</th><th class="col-lg-4 col-sm-4"></th>
		</tr>
		<c:forEach items="${userList }" var="list">
			<tr id="${list.id }_line">
				<td id="${list.id }_id">${list.id }</td><td id="${list.id }_name">${list.name }</td>
				<td>
					<button role="button" class="btn btn-danger" onclick="javascript:del('${list.id}')">삭제</button>
					<button role="button" class="btn btn-primary" onclick="javascript:modify('${list.id}', '${list.name }')">수정</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="col-sm-6 col-lg-6">
		<label>삽입</label>
		<input id="insert_id" type="text" class="form-control" placeholder="아이디" />
		<input id="insert_name" type="text" class="form-control" placeholder="이름" />
		<button role="button" class="btn btn-default btn-block" onclick="javascript:insert()">삽입</button>
	</div>
	<div class="col-sm-6 col-lg-6">
		<label>수정</label>
		<input id="modify_id" type="text" class="form-control" placeholder="아이디" disabled="disabled" />
		<input id="modify_name" type="text" class="form-control" placeholder="이름" />
		<button role="button" class="btn btn-default btn-block" onclick="javascript:modifyAction()">수정</button>
	</div>
</body>
</html>
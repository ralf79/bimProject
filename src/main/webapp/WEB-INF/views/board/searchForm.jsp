<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$(document).ready(function(){ 
	
}); 
</script>
</head>
<body>
<div class="container">
	<form action="../board/search.bim" method="get" class="navbar-form" id="searchForm">
		<div class="form-group">
			<input type="hidden" id="id" name="id"> 
			검색 : 
			<select name="searchType" id="searchType" class="form-control">
				<option value="title" <c:if test="${param.searchType == 'title' }">selected="selected"</c:if>>제목	검색</option>
				<option value="content" <c:if test="${param.searchType == 'content' }">selected="selected"</c:if>>본문	검색</option>
				<option value="title+content" <c:if test="${param.searchType == 'title+content' }">selected="selected"</c:if>>제목+본문	검색</option>
				<option value="writer"  <c:if test="${param.searchType == 'writer' }">selected="selected"</c:if>>글쓴이	검색</option>
			</select>
		</div>
		<div class="form-group">
			<input type="text" name="searchKeyword" id="searchKeyword" value="${param.searchKeyword }" class="form-control">  
		</div>
		<input type="submit" value="검색" class="btn btn-default">
	
	</form>
</div>
	<div class="input-group input-group-sm">
	</div>
</body>
</html>
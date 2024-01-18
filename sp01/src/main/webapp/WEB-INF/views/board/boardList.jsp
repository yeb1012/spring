<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
</head>
<body>
	<table>
		<thead>
		<tr>
		<th>게시판번호</th>
		<th>게시판제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>내용</th>
		
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${boardList}" var="board">
		<tr onclick="location.href='boardInfo?bno=${board.bno}'">
		<td>${board.bno }</td>
		<td>${board.title }</td>
		<td>${board.writer }</td>
		<td><fmt:formatDate value="${board.regDate }" pattern="yyyy년MM월dd일"/></td>
		<td>${board.contents }</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>
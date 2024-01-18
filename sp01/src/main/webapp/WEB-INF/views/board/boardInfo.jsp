<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class = "container">
		<h1>게시글 단건조회</h1>
		
			<table class="table" border=1px>
			<tr>
				<th>게시글번호</th>
				<td>${boardInfo.bno}</td>
				</tr>
				<tr>
				<th>게시글제목</th>
				<td>${boardInfo.title}</td>
				</tr>
				<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${boardInfo.regDate}" pattern="yyyy년MM월dd일"/></td>
				</tr>
				<tr>
				<th>작성자</th>
				<td>${boardInfo.writer}</td>
				</tr>
				<tr>
				<th>내용</th>
				<td><textarea rows="3" cols="2" style="width:100px;" readonly>${boardInfo.contents}</textarea></td>
				</tr>
				<tr>
				<th>이미지</th>
				<td><img src="<c:url value="/resources/${boardInfo.image}"/>"></td>
				</tr>
			</table>
		
			<button type="button" onclick="location.href='boardList'" class="btn btn-dark">목록으로</button>
			<button type="button" class="btn btn-dark">수정</button>
			<button type="button" class="btn btn-dark">삭제</button>
			
	</div>
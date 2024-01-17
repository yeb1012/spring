<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        <span class="fs-4">Emp페이지 </span>
      </a>

      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath }/" class="nav-link active" aria-current="page">Home</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empList" class="nav-link">전체사원조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empInsert" class="nav-link">사원정보등록</a></li>  <!-- ${pageContext.request.contextPath }가 있고 /가 절대경로임 -->
        <li class="nav-item"><a href="#" class="nav-link">☆</a></li>
        <li class="nav-item"><a href="#" class="nav-link">About</a></li>
      </ul>
    </header>
  </div>
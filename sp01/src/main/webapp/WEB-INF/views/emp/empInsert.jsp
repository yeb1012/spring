<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록</title>
</head>
<body>
	<form action="empInsert" method="post">
		<div>
			<label>
				employee_id :
				<input type="number" name=employeeId >
			</label>
			<br>
			<label>
				last_name :
				<input type="text" name="lastName" >
			</label>
			<br>
			<label>
				email :
				<input type="text" name="email" >
			</label>
			<br>
			<label>
				hire_date :
				<input type="date" name="hireDate">
			</label>
			<br>
			<label>
				job_id :
				<input type="text" name="jobId">
			</label>
			<br>
			<label>
				salary :
				<input type="number" name="salary">
			</label>
			<br>
		</div>
		
		<div>
			<button type="button" onclick="location.href='empList'">목록으로</button>
			<button type="submit">등록</button>
			
		</div>
	</form>
</body>
</html>
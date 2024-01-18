<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class = "container">
		<h1>게시글 등록</h1>
		<form name="insertForm" action="boardInsert" method="post">
			<table class="table" border=1px>
				<tr>
				<th>게시글제목</th>
				<td><input type="text" name="title" class="check"></td>
				</tr>
				<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" class="check"></td>
				</tr>
				<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
				</tr>
				<tr>
				<th>이미지</th>
				<td><input type="text" name="image"></td>
				</tr>
			</table>
		
			<button type="button" onclick="location.href='boardList'">목록으로</button>
			<button type="submit">등록</button>
			</form>
	</div>
	<script>
		// if(document.queryselectAll('.check').value == ''){
		// 	alert('필수 조건입니다 입력해주세요')
		// }

		document.querySelector('form[name="insertForm"]')
				.addEventListener('submit', boardInsertJs);

		function boardInsertJs(){
			event.preventDefault();

			let title= document.getElementsByName('title')[0]; //id속성을 제외하곤 값이 하나든 여러든 배열로 넘어온다 그래서 getElements임 그래서 [0]지정도 필요한거고
			let writer= document.getElementsByName('writer')[0]; 

			if(title.value == ''){ //null로 비교하지 말고 ''공백으로 비교하자
				alert('제목이 입력되지 않았습니다')
				title.focus();
				return; //break랑 다름 return이면 함수 스탑 ifelse로 묶지 말자 개별개별 확인해야하는 조건임
			}
			if(writer.value == ''){
				alert('작성자가 입력되지 않았습니다')
				writer.focus();
				return;
			}

			insertForm.submit()
		}	

		document.querySelector('form[name="insertForm"]')
				.removeEventListener('submit', boardInsertJs);

		//Jquery

		$('form[name="insertForm"]').on('submit',boardInsertJq);

		function boardInsertJq(event){
			event.preventDefault();

			let title = $('[name="title"]');
			let writer = $('[name="writer"]');

			if(title.val() == ''){ 
				alert('제이쿼리 제목이 입력되지 않았습니다')
				title.focus();
				return; 
			}
			if(writer.val() == ''){
				alert('제이쿼리 작성자가 입력되지 않았습니다')
				writer.focus();
				return;
			}

			insertForm.submit()
		}
		
		
		
	</script>
	

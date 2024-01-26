<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class = "container">
		<h1>게시글 수정</h1>
		<form name="updateForm">
			<table class="table" border=1px>
				<tr>
				<th>게시글번호</th>
				<td><input type="text" name="bno" value="${boardInfo.bno }" readonly></td>
				</tr>
				<tr>
				<th>게시글제목</th>
				<td><input type="text" name="title"  value="${boardInfo.title }"></td>
				</tr>
				<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer }"></td>
				</tr>
				<tr>
				<th>내용</th>
				<td><textarea name="contents"> ${boardInfo.contents }</textarea></td>
				</tr>
				<tr>
				<th>이미지</th>
				<td><input type="text" name="image" value="${boardInfo.image }"></td>
				</tr>
			</table>
		
			<button type="button" onclick="location.href='boardList'">목록으로</button>
			<button type="button">저장</button>
			</form>
	</div>
	<script>
		$('form button:contains(저장)').on('click', boardUpdateAjax);

		function boardUpdateAjax(event){
			//통신 진행 여부 결정
			if(!validation()) return;

			//통신을 위한 데이터 가져오기
			let boardDta = getBoardInfo();
			console.log('boardDta', boardDta);

			$.ajax('boardUpdate',{
				type:'post',
				//커맨드 객체
				//data : boardDta
				//@RequestBody
				contentType:'application/json',
				data : JSON.stringify(boardDta)
			})
			.done(result => {
				console.log(result)
			})
			.fail(err=>console.log(err))			
		}

		function validation(){
			let title = $('[name="title"]');
			let writer = $('[name="writer"]');

			if(title.val() == ''){
				alert('제목을 확인해주세요')
				title.focus();
				return false;
			}
			if(writer.val() == ''){
				alert('작성자를 확인해주세요')
				writer.focus();
				return false;
			}

			return true;
		}

		function getBoardInfo(){
			let formAry = $('form[name="updateForm"]').serializeArray(); //입력태그 종류가 동시에 사용될 경우 매번 체크해 주는거보다 serializeArray를 써주면 좋다
			console.log(formAry);

			let formObj = {};
			$(formAry).each((idx, tag)=>{
				console.log(tag);
				formObj[tag.name] = tag.value;
			});
			return formObj;
		}
	</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
	});

</script>
</head>
<body>

	<form:form id="writeForm" commandName="writeFrm" enctype="multipart/form-data">
			<input type="text" name="title" placeholder="제목">
			<input type="text" name="userId" placeholder="userId">
			<div class="tripPart">
				<div class="part">
					<input type="text" name="tripPartListVO.startTime" placeholder="시작시간"><br/>
					<input type="text" name="tripPartListVO.endTime" placeholder="끝나는시간"><br/>
					<input type="text" name="tripPartListVO.place" placeholder="장소를 입력해주세요"><br/>
				
						<input class="geocomplete" class="contorls" type="text" name="tripPartListVO.map" 
						placeholder="상세주소를 입력해주세요." size="90" onClick="value=''" />
		
					<div class="map_canvas"></div>
					
					
					<select name="tripPartListVO.timeControl">
					    <option value="">시간구분</option>
					    <option value="오전">오전</option>
					    <option value="오후">오후</option>
					</select>
					
					<input type="file" name="tripPartListVO.file"><br/>
					<textarea name="tripPartListVO.content" placeholder="내용을 입력해주세요"></textarea><br/><hr/>
				</div>
			</div>
			<input type="button" id="addBtn" value="+">
			
			<textarea id="overAll" name="overAll" placeholder="총평을 입력해주세요"></textarea>
			
			<input type="button" id="writeBtn" value="submit">
			
	</form:form>
</body>
</html>
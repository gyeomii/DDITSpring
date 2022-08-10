<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<script>
	alert("회원등록에 성공했습니다.\n 회원리스트 페이지로 이동합니다.");
	
	window.opener.location.href = "<%= request.getContextPath()%>/member/list.do";
	window.close();
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>记录</title>
<style type="text/css">
#ta tr{/*表格的行样式*/
		height: 35px;
			}
td{
width: 100px;
}
.buttenda{
position:absolute;
top:120px;
left:57px;
}
</style>
</head>
<body>
<table border="1">
<tr>
<td>转账账号</td>
<td>收款账号</td>
<td>收款人姓名</td>
<td>转账金额</td>
</tr>
<c:forEach  items="${PageInfo.list}" var="page">
<tr>
<td>${page.accout}</td>
<td>${page.accin}</td>
<td>${page.name}</td>
<td>${page.money}</td>
</c:forEach>
</table>
<div  class=buttenda>
<a>当前页数</a>
<input   style="color: red; width: 25px; height:13px"  type="text"  value="${PageInfo.pageNumber}" onfocus="this.blur();"/>
&nbsp;&nbsp;&nbsp;
<!-- onfocus="this.blur()  去掉焦点 -->
	<a href="show?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;" </c:if> >上一页</a>
	&nbsp;
	<a href="show?pageNumber=2&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.total<2}"> onclick="javascript:return false;"</c:if>>2</a>
	<a >.......</a>
	<c:if test="${PageInfo.total>=5}">
	
	<a   href="show?pageNumber=${PageInfo.total-2}&pageSize=${PageInfo.pageSize}">${PageInfo.total-2}</a>
	<a href="show?pageNumber=${PageInfo.total-1}&pageSize=${PageInfo.pageSize}">${PageInfo.total-1}</a>
	&nbsp;
	</c:if>
	<a href="show?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber>=PageInfo.total }">  onclick="javascript:return false;" </c:if> >下一页</a>
	
	<a href="index.jsp">
	<input  type="button"  value="继续转账"/>
	</a>
</div>

</body>
</html>
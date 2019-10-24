<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="transfer"  method="post">
<table>
<tr>
<td></td>
<td></td>

<tr>
<td>转账账户:</td>
<td><input  type="text"  name="accOutAccNo"/> </td>
</tr>
<tr>
<td>密码:</td>
<td><input  type="password"  name="accOutPassword"/></td>
</tr>

<tr>
<td>金额:</td>
<td><input  type="text"  name="accOutBalance"/></td>
</tr>

<tr>
<td>收款账户:</td>
<td><input  type="text"  name="accInAccNo"/></td>
</tr>

<tr>
<td>收款人姓名:</td>
<td><input  type="text"  name="accInName"/></td>
</tr>
</table>
<input  type="submit" value="转账">
<input  type="reset" value="重置">
	<a href="/bank/show">
	<input  type="button"  value="转账记录"/>
	</a>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>银行列表</title>

</head>

<body bgcolor="#FFFFFF">
<form name="bnkBankForm" method="post" action="" onsubmit="">
<table width="95%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="36" align="center">银行列表 - 查询</td>
	</tr>
	<tr align="center">
		<td>
		<table width="96%" border="1" cellpadding="1" cellspacing="0">
			<tr>

				<td width="30%" align="left" bgcolor="#E8E8E8" class="z_left1">银行ID:</td>
				<td><font size="2"><input type="text" name="bnkBankId"
					maxlength="4" size="6" /> </font></td>
			</tr>
			<tr>

				<td width="30%" align="left" bgcolor="#E8E8E8" class="z_left1">银行编码:</td>
				<td><font size="2"><input type="text" name="bnkCode"
					maxlength="4" size="6" /> </font></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td height="32"><input type="submit" value="查询" /> <input
			type="submit" value="新增" /> <input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</body>
</html>
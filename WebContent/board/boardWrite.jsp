<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>스트럿츠2 게시판</title>
<link rel="stylesheet" href="${path}/board/common/css/css.css"
	type="text/css" />
<script type="text/javascript">
	function validation() {

		var frm = document.forms(0);

		if (frm.subject.value == "") {
			alert("제목을 입력해주세요.");
			return false;
		}

		else if (frm.name.value == "") {
			alert("이름을 입력해주세요.");
			return false;
		}

		else if (frm.password.value == "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		}

		else if (frm.content.value == "") {
			alert("내용을 입력해주세요.");
			return false;
		}

		return true;
	}
</script>
</head>

<body>
	<table width="600" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center">
				<h2>스트럿츠2 게시판</h2>
			</td>
		</tr>
	</table>
	<c:if test="${subject == null}">
		<c:set var="action" value="write.do" />
	</c:if>
	<c:if test="${subject != null}">
		<c:set var="action" value="modify.do" />
	</c:if>

	<form action="${action}" method="post" enctype="multipart/form-data"
		onsubmit="return validation();">

		<input type="hidden" name="no" value="${no}" />
		<input type="hidden" name="currentPage" value="${currentPage}" />
		<input type="hidden" name="old_file" value="${file_savname}" />

		<table width="600" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="right" colspan="2">
					<font color="#FF0000">*</font> 는 필수 입력사항입니다.
				</td>
			</tr>

			<tr bgcolor="#777777">
				<td height="1" colspan="2"></td>
			</tr>

			<tr>
				<td width="100" bgcolor="#F4F4F4">
					<font color="#FF0000">*</font> 제목
				</td>
				<td width="500" bgcolor="#FFFFFF">
					<input type="text" name="subject" value="${subject}"
						style="width: 370px" maxlength="50" />
				</td>
			</tr>

			<tr bgcolor="#777777">
				<td height="1" colspan="2"></td>
			</tr>

			<tr>
				<td bgcolor="#F4F4F4">
					<font color="#FF0000">*</font> 이름
				</td>
				<td bgcolor="#FFFFFF">
					<input type="text" name="name" value="${name}" style="width: 100px"
						maxlength="20" />
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="2"></td>
			</tr>

			<tr>
				<td bgcolor="#F4F4F4">
					<font color="#FF0000">*</font> 비밀번호
				</td>
				<td bgcolor="#FFFFFF">
					<input type="text" name="password" value="${password}"
						style="width: 100px" maxlength="20" />
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="2"></td>
			</tr>

			<tr>
				<td bgcolor="#F4F4F4">
					<font color="#FF0000">*</font> 내용
				</td>
				<td bgcolor="#FFFFFF">
					<input type="text" name="content" value="${content}" style="width: 50ch;height: 10ch;" />
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="2"></td>
			</tr>

			<tr>
				<td bgcolor="#F4F4F4">첨부파일</td>
				<td bgcolor="#FFFFFF">
					<input type="file" name="upload" value="" id="upload" />
					<c:if test="${file_orgname != null}">
						&nbsp; * ${file_orgname} 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
					</c:if>
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="2"></td>
			</tr>

			<tr>
				<td height="10" colspan="2"></td>
			</tr>


			<tr>
				<td align="right" colspan="2">
					<input name="submit" type="submit" value="작성완료" class="inputb" />
						<input name="list" type="button" value="목록" class="inputb"
							onclick="javascript:location.href='list.do?currentPage=${currentPage}'" />
				</td>
			</tr>

		</table>
	</form>
</body>
</html>


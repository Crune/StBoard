<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>스트럿츠2 게시판</title>
	<link rel="stylesheet" href="${path}/board/common/css/css.css" type="text/css" />
	<script type="text/javascript">
		function open_win_noresizable (url, name) {
			var oWin = window.open(url, name, "scrollbars=no,status=no,resizable=no,width=300,height=150");
		}
	</script>
</head>
  
  <body>
  
  	<table width="600" border="0" cellspacing="0" cellpadding="2">
  		<tr>
  			<td align="center"><h2>스트럿츠2 게시판</h2></td>
  		</tr>
  		<tr>
  			<td height="20"></td>
  		</tr>
  	</table>
		
<table width="600" border="0" cellspacing="0" cellpadding="0">
      
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
			
      <tr>
        <td bgcolor="#F4F4F4">  번호 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;${no}
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td width="100" bgcolor="#F4F4F4">  제목</td>
        <td width="500" bgcolor="#FFFFFF">
          &nbsp;&nbsp;${subject}
        </td>
      </tr>
      							
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  글쓴이 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;${name}
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  내용 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;${content}
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  조회수 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;${readhit}
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  등록날짜 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<fmt:formatDate value="${regdate}" pattern="yy. MM. dd" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  첨부파일 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<a href="down.do?no=${no}">${file_orgname}</a> 
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
        
	<input name="list" type="button" value="수정" class="inputb" 
	onclick="javascript:open_win_noresizable('checkForm.do?no=${no}&currentPage=${currentPage}','modify')" />
					
	<input name="list" type="button" value="삭제" class="inputb" 
	onclick="javascript:open_win_noresizable('checkForm.do?no=${no}&currentPage=${currentPage}','delete')" />

	<input name="list" type="button" value="목록" class="inputb" 
	onclick="javascript:location.href='list.do?currentPage=${currentPage}'" />

        </td>
      </tr>

  </table>
 </body>
</html>


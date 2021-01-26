
<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<%	
	String searchField = request.getParameter("searchField");
	String searchData = request.getParameter("searchData");
	out.println(searchField+searchData);
	if(searchField==null||searchField.length()<=0||searchData==null||searchData.length()<=0) {
			searchField="";
			searchData="";
	}
	BoardDAO dao = new BoardDAO();
	int count = dao.getTotalRecordCount(searchField, searchData);
	//전체게시글의 갯수를 읽어들여야한다.
	//한 화면에 보여질 갯수
	int pageSize = 10;	
	//현재 페이지 번호
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null||pageNum.length() <= 0) {
		pageNum = "1";					//페이저 넘 지정안해준 경우 기본적으로 1페이지 보여라
	}
	int currentPage = Integer.parseInt(pageNum);
	
	//현재 페이지에 보여질 시작번호, 끝번호
	int startRow = (currentPage - 1)*pageSize + 1;
	int endRow = currentPage*pageSize;
	
	
	//테이블에 표시할 번호
	int number = count - (currentPage-1)*pageSize; 
	
	int pageCount = 0;
	int startPage = 1;
	int endPage = 1;
	if (count > 0) {
		pageCount = count/pageSize + (count%pageSize == 0?0:1);
	}
	if(currentPage%10 != 0) {
		startPage = (int)(currentPage/10)*10 + 1;
	}else {
		startPage = ((int)(currentPage/10)-1)*10 + 1;
	}
	
	int pageBlock = 10;
	endPage = startPage + pageBlock -1;
	if(endPage>pageCount) {
		endPage = pageCount;
	}
	
	
	
	out.println("총 게시물 갯수 : "+count+"<br>");
	out.println("시작 열 : "+startRow+"<br>");
	out.println("마지막 열 : "+endRow+"<br>");
	out.println("테이블에 표시할 번호 : "+number+"<br>");
	out.println("총 페이지 갯수"+pageCount+"<br>");
	out.println("표시되는 시작 페이지 : "+startPage+"<br>");
	out.println("표시되는 끝 패이지"+endPage+"<br>");
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table align="center" border="1">
		<tr>
			<td>순번</td>
			<td>작성자</td>
			<td>제목</td>
			<td>이메일</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
	
<% 	String referer = request.getHeader("REFERER");		//이전페이지
	String ip = Inet4Address.getLocalHost().getHostAddress();
	out.println(referer+"<br>" + ip+"<br>");
	//ArrayList<BoardDTO> arr = dao.getListAll();
	ArrayList<BoardDTO> list = dao.getListAll(startRow, endRow);
	for(int i=0; i<list.size(); i++) {
		BoardDTO dto = new BoardDTO();
		dto = list.get(i);
		int no = dto.getNo();
		int num = dto.getNum();
		String jakseongja = dto.getJakseongja();
		String subject = "";
		String content = dto.getContent();
		String email = dto.getEmail();
		String passwd = dto.getPasswd();
		int ref = dto.getRef();
		int re_step = dto.getRe_step();
		String temp = "";
		String parentinfo = dto.getParentInfo();
		for(int j=0; j<dto.getRe_step(); j++) {
			temp = temp+"&nbsp&nbsp";
		}
		
		subject =dto.getSubject();;
		int re_level = dto.getRe_level();
		String myInfo = ref+"/"+re_step+"/"+re_level;
		int hit = dto.getHit();
		String wdate = dto.getWdate();
		
		BoardDTO dto2 = dao.getSelectOne(no);
		int replCount_= dao.getreplyCount(dto2);
		String replCount = "";
		
		if(replCount_!=0&&parentinfo==null) {
			replCount_ = dao.getreplyCount(dto2);
			replCount = "["+Integer.toString(replCount_)+"]";
		}else if(replCount_!=0&&parentinfo!=null){
			String[] parentInfo = parentinfo.split("/");
			replCount_ = dao.getreplyCount(myInfo);
			if(replCount_==0) {
				replCount = "";
			}else{
			replCount = "[" + Integer.toString(replCount_) + "]";		
			}		
		}else {
			replCount = "";
		}
		
		
%>		
		<tr>
			<td><%=number-- %></td>
			<td><%=jakseongja%></td>
			<td><%=temp%><a href="#" onclick="goView('<%=no%>');"><%=subject%></a><%=replCount%></td>
			<td><%=email%></td>
			<td><%=hit%></td>
			<td><%=wdate%></td>
		</tr>
		
		
		
	<%}%>
	
		<tr>
			<td colspan="6" align="center">
				<% if(startPage>=11) { %>
						<a href="list.jsp?pageNum=<%=startPage-10%>">이전</a>			<%--이전 페이지 블록 구현, 클릭하면 현재 페이지의 startPage-10페이지로 이동 --%>
				<%}%>
				<% for(int n=startPage; n<=endPage; n++){ %>
						<%if(n == currentPage) {%>
						<span style="color:red;"><b>[<%=n%>]</b></span>
						<%} else {  %>
							<a href="list.jsp?pageNum=<%=n%>">[<%=n%>]</a>			
						<%}%>
				<% }%>
				
				<% if(endPage<pageCount) { %>
						<a href="list.jsp?pageNum=<%=startPage+10%>">다음</a>			<%--다음 페이지 블록 구현, 클릭하면 현재 페이지의 startPage-10페이지로 이동 --%>
				<%}%>
			</td>
		</tr>
		<tr>
			<td colspan="6" align="center">
				<form name="searchForm">
					<select name="searchField">
						<option value="" selected="selected">-선택-</option>
						<option value="subject">제목</option>
						<option value="content">내용</option>
						<option value="all">제목+내용</option>
					</select>
					<input type="text" name="searchData">
					<button type="button" onclick="search()">검색하기</button>
				</form>
			</td>
		</tr>
	
	
	</table>
	
	클라이언트ip <%=request.getRemoteAddr() %><br>
	요청URL <%=request.getRequestURI()%><br>
	컨텐스트경로 <%=request.getContextPath()%><br>
	서버이름 <%=request.getServerName()%><br>
	서버포트 <%=request.getServerPort()%><br>
	
	
	
	
</body>
</html>

<script>

function goView(value1) {
	location.href='view.jsp?no='+value1;
}


function search() {
	searchForm.method="post";
	searchForm.action="listSearch.jsp";
	searchForm.submit();
}

</script>


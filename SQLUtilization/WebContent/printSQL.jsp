<%@page import="src.model.DAO.employeesDTO"%>
<%@page import="src.model.DTO.employeesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<%
employeesDAO dao = new employeesDAO();

employeesDTO dto = dao.getSelectOne();










%>

<table align="center" border="1">
<tr>
	<td>employee_id</td>
	<td><%=dto.getEmployee_id() %></td>
</tr>


<tr>
	<td>first_name</td>
	<td><%=dto.getFirst_name() %></td>
</tr>

<tr>
	<td>last_name</td>
	<td><%=dto.getLast_name() %></td>
</tr>

<tr>
	<td>email</td>
	<td><%=dto.getEmail() %></td>
</tr>

<tr>
	<td>phone_number</td>
	<td><%=dto.getPhone_number() %></td>
</tr>

<tr>
	<td>hire_date</td>
	<td><%=dto.getHire_date() %></td>
</tr>

<tr>
	<td>job_id</td>
	<td><%=dto.getJob_id() %></td>
</tr>

<tr>
	<td>salary</td>
	<td><%=dto.getSalary() %></td>
</tr>

<tr>
	<td>commission_pct</td>
	<td><%=dto.getCommission_pct() %></td>
</tr>

<tr>
	<td>manager_id</td>
	<td><%=dto.getManager_id() %></td>
</tr>

<tr>
	<td>department_id</td>
	<td><%=dto.getDepartment_id() %></td>
</tr>


</table>
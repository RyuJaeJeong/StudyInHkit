<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>    
<!DOCTYPE html>
<table border="1" style="width: 300px; height: 300px;">
    <tr>
        <td id="a7" align="center" onclick="inp('7');">7</td>
        <td id="a8" align="center" onclick="inp('8');">8</td>
        <td id="a9" align="center" onclick="inp('9');">9</td>
        <td align="center" onclick="inp('+');">+</td>
    </tr>
    <tr>
        <td id="a4" align="center" onclick="inp('4');">4</td>
        <td id="a5" align="center" onclick="inp('5');">5</td>
        <td id="a6" align="center" onclick="inp('6');">6</td>
        <td align="center" onclick="inp('-');">-</td>
    </tr>
    <tr>
        <td id="a1" align="center" onclick="inp('1');">1</td>
        <td id="a2" align="center" onclick="inp('2');">2</td>
        <td id="a3" align="center" onclick="inp('3');">3</td>
        <td align="center" onclick="inp('*');">*</td>
    </tr>
    <tr>
        <td align="center" onclick="cancel();">c</td>
        <td id="a0" align="center" onclick="inp('0');">0</td>
        <td align="center" onclick="solve();">=</td>
        <td align="center" onclick="inp('/');">/</td>
    </tr>
</table>
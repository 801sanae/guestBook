<%@page import="com.hanains.guestbook.vo.GuestBookVo"%>
<%@page import="com.hanains.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	int no = Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password");
	
	GuestBookDao dao = new GuestBookDao();
	GuestBookVo vo = new GuestBookVo();
	
	vo.setNo(no);
	vo.setPassword(password);
	
	dao.delete(vo);
	response.sendRedirect("index.jsp");
%>

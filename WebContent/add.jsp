<%@page import="com.hanains.guestbook.vo.GuestBookVo"%>
<%@page import="com.hanains.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String password=request.getParameter("pass");
	String message=request.getParameter("content");
	
	GuestBookDao dao = new GuestBookDao();
	GuestBookVo vo = new GuestBookVo();
	
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	
	dao.insert(vo);
	
	response.sendRedirect("index.jsp");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="first.RegisterDao"%>  
<jsp:useBean id="obj" class="first.User"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
/*
boolean  
if ()//if data entered is valid 
{*/
/*	
int status=RegisterDao.register(obj);  
if(status>0)  
out.print("You are successfully registered");
//}*/
	boolean validdata = RegisterDao.Validate(obj);
//String validdata = RegisterDao.Validate(obj);

//out.print(validdata);


if(validdata == true )
{
	int status=RegisterDao.reg(obj);  
	if(status>0)  
		out.print("You are successfully registered");  
}
else 
{
	if(RegisterDao.ValidateMsg.length() <= 6)
	{
		
		out.print("Please check data and try again");
	}
	else
	{
		out.print(RegisterDao.ValidateMsg);
	}
}



%> 
<a href="login.jsp">login</a>

</body>
</html>
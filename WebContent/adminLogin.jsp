<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
java.version: <%=System.getProperty("java.version") %><br/>
java.home: <%=System.getProperty("java.home") %><br/>
os.name: <%=System.getProperty("os.name") %><br/>
user.name: <%=System.getProperty("user.name") %><br/>
user.home: <%=System.getProperty("user.home") %><br/>
user.dir: <%=System.getProperty("user.dir") %><br/>
<form>
ID: <input type="text" name="ID"><br>
PW: <input type="text" name="Password">
</form>
				
<%
    // This scriptlet declares and initializes "date"
    System.out.println( "Evaluating date now" );
    java.util.Date date = new java.util.Date();
%>
Hello!  The time is now
<%
    out.println( date );
    out.println( "<BR>Your machine's address is " );
    out.println( request.getRemoteHost());
%>

</body>
</html>
<%@ page import="javax.ws.rs.client.ClientBuilder" %>
<%@ page import="javax.ws.rs.client.WebTarget" %>
<%@ page import="javax.ws.rs.core.MediaType" %>
<%@ page import="swa.ass4.domain.User" %>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

WebTarget userTarget = ClientBuilder.newClient().target("http://localhost:9000").path("users").path(username);
User user = userTarget.request(MediaType.TEXT_XML).get(User.class);

if (user != null && user.getPassword().equals(password)) {
	session.setAttribute("user", user);
	response.sendRedirect("index.jsp");
	
} else {
	out.print("<p>Authentication failed</p>");
	%><%@ include file="login.jsp" %><%
}
%>
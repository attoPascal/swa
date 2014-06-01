<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.ws.rs.client.ClientBuilder" %>
<%@ page import="javax.ws.rs.client.WebTarget" %>
<%@ page import="javax.ws.rs.core.MediaType" %>
<%@ page import="javax.ws.rs.core.GenericType" %>
<%@ page import="swa.ass4.domain.User" %>
<%@ page import="swa.ass4.domain.Course" %>

<%
if (session.getAttribute("user") instanceof User) { 
	User user = (User) session.getAttribute("user");
	Map<Course, User.Grade> userCourses = user.getCourses();
%>

<h1>Hello <%= user.getFirstName() %> <%= user.getLastName() %></h1>

<h2>Grades</h2>

<table border="1">
	<tr>
		<th>Course</th>
		<th>Grade</th>
	</tr>

<% for (Map.Entry<Course, User.Grade> e : userCourses.entrySet()) { %>
	<tr>
		<td><%= e.getKey().toString() %></td>
		<td><%= e.getValue() %>
	</tr>
<% } %>

</table>

<h2>Courses</h2>

<table border="1">

<%
WebTarget coursesTarget = ClientBuilder.newClient().target("http://localhost:9000").path("courses");
List<Course> allCourses = coursesTarget.request(MediaType.TEXT_XML).get(new GenericType<List<Course>>() {});

//remove courses with invalid registration timeframe
Iterator<Course> it = allCourses.iterator();
while (it.hasNext()) {
	Course c = it.next();
	Date registrationBegin = c.getRegistrationBegin();
	Date registrationEnd = c.getRegistrationEnd();
	Date now = new Date();
	
	if (now.before(registrationBegin) || now.after(registrationEnd)) {
		it.remove();
	}
}

for (Course c : allCourses) { 
	String registerLink;
	if (userCourses.containsKey(c)) {
		registerLink = "<a href='deregister.jsp?id=" + c.getId() + "'>Deregister</a>"; 
	} else {
		registerLink = "<a href='register.jsp?id=" + c.getId() + "'>Register</a>"; 
	}
%>
	<tr>
		<td><%= c.getName() %></td>
		<td><%= registerLink %></td>
	</tr>

<% } %>

</table>

<p><a href="logout.jsp">Logout</a>

<% } else { %>
<%@ include file="login.jsp" %>
<% } %>
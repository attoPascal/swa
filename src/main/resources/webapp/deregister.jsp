<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="javax.ws.rs.client.ClientBuilder" %>
<%@ page import="javax.ws.rs.client.WebTarget" %>
<%@ page import="javax.ws.rs.client.Entity" %>
<%@ page import="javax.ws.rs.core.MediaType" %>
<%@ page import="javax.ws.rs.core.GenericType" %>
<%@ page import="swa.ass4.domain.User" %>
<%@ page import="swa.ass4.domain.Course" %>

<%
	User user = (User) session.getAttribute("user");
	Map<Course, User.Grade> userCourses = user.getCourses();
	int courseId = Integer.valueOf(request.getParameter("id"));
	
	Iterator<Map.Entry<Course, User.Grade>> it = userCourses.entrySet().iterator();
	
	while (it.hasNext()) {
		Course c = it.next().getKey();
		if (c.getId() == courseId) {
			it.remove();
			break;
		}
	}
	
	WebTarget target = ClientBuilder.newClient().target("http://localhost:9000");
	WebTarget userTarget = target.path("users").path(user.getUserName());
	Entity<User> userEntity = Entity.entity(user, MediaType.TEXT_XML);
	User newUser = userTarget.request(MediaType.TEXT_XML).put(userEntity, User.class);
	
	session.setAttribute("user", newUser);
	
	response.sendRedirect("index.jsp");
%>
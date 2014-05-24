Start the service using "mvn -Pserver" and keep it running!

Running "mvn -Pclient" executes the Java client

Running "mvn -Pwebapp" executes an embedded jetty server that is configured with JSP and Servlet support running on port 9001 - with a dummy jsp index.jsp that can be found in src/main/resources/webapp

Running "mvn -Pserver" executes a jetty server with support for Web Services running on port 9000 - with an examplary jax-rs resource available under http://localhost:9000/parties/count and a jax-ws resource available under http://localhost:9000/Greeter?wsdl



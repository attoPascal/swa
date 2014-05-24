package swa.ass4.server;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import swa.ass4.server.cxf.Greeter;
import swa.ass4.server.cxf.GreeterImpl;

public class CXFBackendServer {
	private static final int BACKEND_PORT = 9000;

	private final static String URL = "http://localhost:9000/";
	
    private static final Logger LOG = Logger.getLogger(CXFBackendServer.class.getName());


	public static void main(String[] args) throws Exception {
		Server httpServer;
		String busFactory = System
				.getProperty(BusFactory.BUS_FACTORY_PROPERTY_NAME);
		System.setProperty(BusFactory.BUS_FACTORY_PROPERTY_NAME,
				"org.apache.cxf.bus.CXFBusFactory");
		try {
			// Start up the jetty embedded server
			httpServer = new Server(BACKEND_PORT);

			ServletContextHandler context = new ServletContextHandler(
					ServletContextHandler.NO_SESSIONS);
			context.setContextPath("/");
			httpServer.setHandler(context);
			
//			This servlet is only necessary if jax-rs resources are published otherwise the CXFNonSpringServlet can be used. 
			ServletHolder cxfServlet = context.addServlet(
					CXFNonSpringJaxrsServlet.class, "/*");
//			ServletHolder cxfServlet = context.addServlet(
//			CXFNonSpringServlet.class, "/*");
		
			cxfServlet.setInitOrder(1);
//			tell the jax-rs servlet which services exist
			cxfServlet.setInitParameter("jaxrs.serviceClasses",
					"swa.ass4.server.DummyRestResource");

			httpServer.start();
			
//			publish a simple jax-ws service  			
			Greeter impl = new GreeterImpl();
			Endpoint.publish("/Greeter", impl);

		  LOG.info("Server URI: " + URL);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// clean up the system properties
			if (busFactory != null) {
				System.setProperty(BusFactory.BUS_FACTORY_PROPERTY_NAME,
						busFactory);
			} else {
				System.clearProperty(BusFactory.BUS_FACTORY_PROPERTY_NAME);
			}
		}
	}

}

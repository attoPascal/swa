package swa.ass4.webapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebApp {

    
    public static void main(String[] args) throws Exception {
    	
    	Main main = new Main(9001);
    	 main.start();
         main.waitForInterrupt();
    	
    	
//        Server server = new Server(8080);
//        WebAppContext webapp = new WebAppContext();
//        webapp.setContextPath("/");
//        webapp.setResourceBase("./src/main/webapp/");
//        webapp.setWelcomeFiles(new String[] {"index.jsp"});
//        server.setHandler(webapp);
//        server.start();
//        server.join();
    }

}

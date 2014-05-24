package swa.ass4.server.cxf;
@javax.jws.WebService(endpointInterface = "swa.ass4.server.cxf.Greeter")
 
public class GreeterImpl implements Greeter {
 
  /* (non-Javadoc)
 * @see swa.ass4.server.cxf.Greeter2#greetMe(java.lang.String)
 */
@Override
public String greetMe(String me)
  {
    System.out.println("Executing operation greetMe");
    System.out.println("Message received: " + me + "\n");
    return "Hello " + me;
  }
 
  /* (non-Javadoc)
 * @see swa.ass4.server.cxf.Greeter2#sayHi()
 */
@Override
public String sayHi()
  {
    System.out.println("Executing operation sayHi\n");
    return "Bonjour";
  }
}
package swa.ass4.server.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Greeter {

	public String greetMe(@WebParam(name="me")String me);

	public String sayHi();

}
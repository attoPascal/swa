package swa.ass4.client;

import javax.swing.JOptionPane;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.Connection;
import swa.ass4.client.gui.ControlPanel;
import swa.ass4.client.gui.Login;
import swa.ass4.domain.User;

public class ClientLauncher {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// open connection window
		Connection connection = new Connection();
		JOptionPane.showMessageDialog(null, connection, "Connect to Server", JOptionPane.PLAIN_MESSAGE);
		String url = connection.getConnectionURL();

		// open login window
		Login login = new Login();
		JOptionPane.showMessageDialog(null, login, "Login", JOptionPane.PLAIN_MESSAGE);
		String username = login.getUsername();

		// connect to server
		WebTarget rootTarget = ClientBuilder.newClient().target(url);
		WebTarget userTarget = rootTarget.path("users").path(username);

		// get user object
		User user = userTarget.request(MediaType.TEXT_XML).get(User.class);

		// open control panel
		ControlPanel controlPanel = ControlPanel.getInstance(user);
	}
}

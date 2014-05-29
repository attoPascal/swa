package swa.ass4.client;

import javax.swing.JOptionPane;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.ConnectionPanel;
import swa.ass4.client.gui.ControlPanel;
import swa.ass4.client.gui.LoginPanel;
import swa.ass4.domain.User;

public class ClientLauncher {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// open connection window
		ConnectionPanel connection = new ConnectionPanel();
		JOptionPane.showMessageDialog(null, connection, "Connect to Server", JOptionPane.PLAIN_MESSAGE);
		String url = connection.getConnectionURL();

		// open login window
		LoginPanel login = new LoginPanel();
		JOptionPane.showMessageDialog(null, login, "Login", JOptionPane.PLAIN_MESSAGE);
		String username = login.getUsername();
		String password = login.getPassword();

		// connect to server
		WebTarget rootTarget = ClientBuilder.newClient().target(url);
		WebTarget userTarget = rootTarget.path("users").path(username);

		// get user object
		User user = userTarget.request(MediaType.TEXT_XML).get(User.class);
		
		// check authentication
		if (user.getPassword().equals(password)) {
			// open control panel
			ControlPanel controlPanel = ControlPanel.getInstance(user, rootTarget);
		
		} else {
			// show error message
			JOptionPane.showMessageDialog(null, "Authentication failed", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

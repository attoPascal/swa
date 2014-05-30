package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.CreateUserPanel;
import swa.ass4.domain.User;

public class CreateUser implements ActionListener {
	private WebTarget target;
	
	public CreateUser(WebTarget target) {
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CreateUserPanel panel = new CreateUserPanel();
		JOptionPane.showMessageDialog(null, panel, "Create User", JOptionPane.PLAIN_MESSAGE);
		
		WebTarget userTarget = target.path("users");
		User newUser = panel.getUser();
		
		Entity<User> userEntity = Entity.entity(newUser, MediaType.TEXT_XML);
		User response = userTarget.request(MediaType.TEXT_XML).post(userEntity, User.class);
		
		System.out.println("User " + response.getUserName() + " created");
	}

}

package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.UpdatePasswordPanel;
import swa.ass4.domain.User;

public class UpdatePassword implements ActionListener {
	private User user;
	private WebTarget target;
	
	public UpdatePassword(User user, WebTarget target) {
		this.user = user;
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		UpdatePasswordPanel panel = new UpdatePasswordPanel();
		JOptionPane.showMessageDialog(null, panel, "Update Password", JOptionPane.PLAIN_MESSAGE);
		
		if (!panel.getOldPassword().equals(user.getPassword())) {
			throw new RuntimeException("Wrong old password entered");
		} else {
			WebTarget userTarget = target.path("users").path(user.getUserName());
			String password = panel.getNewPassword();
			
			// update server
			Entity<String> passwordEntity = Entity.entity(password, MediaType.TEXT_PLAIN);
			String response = userTarget.request(MediaType.TEXT_PLAIN).put(passwordEntity, String.class);
			
			// update local user object
			user.setPassword(password);
			
			System.out.println(response);
		}
	}

}

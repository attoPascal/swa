package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.ManageUsersPanel;
import swa.ass4.domain.User;
import swa.ass4.domain.User.Role;

public class ManageUsers implements ActionListener {
	private User user;
	private WebTarget target;
	
	public ManageUsers(User user, WebTarget target) {
		this.user = user;
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		WebTarget usersTarget = target.path("users");
		List<User> users = usersTarget.request(MediaType.TEXT_XML).get(new GenericType<List<User>>() {});
		
		// remove active user from list: should not modify themselves
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
		    if (it.next().getUserName().equals(user.getUserName())) {
		        it.remove();
		    }
		}
		
		ManageUsersPanel panel = new ManageUsersPanel(users);
		int result = JOptionPane.showConfirmDialog(null, panel, "Manage Users", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			List<JComboBox<Role>> roles = panel.getRoles();
			List<JCheckBox> checkBoxes = panel.getCheckBoxes();
			
			for (int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				WebTarget userTarget = usersTarget.path(u.getUserName());
				
				JComboBox<User.Role> jcb = roles.get(i);
				User.Role r = jcb.getItemAt(jcb.getSelectedIndex());
				
				boolean toDelete = checkBoxes.get(i).isSelected();
				
				if (!u.getRole().equals(r)) {
					u.setRole(r);
					
					Entity<User> userEntity = Entity.entity(u, MediaType.TEXT_XML);
					User response = userTarget.request(MediaType.TEXT_XML).put(userEntity, User.class);
					System.out.println(response);
				}
				
				if (toDelete) {
					userTarget.request().delete();
				}
				
				
			}
		}
	}

}

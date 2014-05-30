package swa.ass4.client.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swa.ass4.domain.User;
import net.miginfocom.swing.MigLayout;

public class ManageUsersPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> userNames;
	private List<JComboBox<User.Role>> roles;
	private List<JCheckBox> checkBoxes;
	
	public ManageUsersPanel(List<User> users) {
		this.setLayout(new MigLayout("wrap 3, fill"));
		
		userNames = new ArrayList<>();
		roles = new ArrayList<>();
		checkBoxes = new ArrayList<>();
		
		for (User u : users) {
			userNames.add(new JLabel(u.getUserName()));
			
			JComboBox<User.Role> roleSelect = new JComboBox<>(User.Role.values());
			roleSelect.setSelectedItem(u.getRole());
			roles.add(roleSelect);
			
			checkBoxes.add(new JCheckBox());
		}
		
		this.add(new JLabel("USERNAME"));
		this.add(new JLabel("ROLE"));
		this.add(new JLabel("DELETE"));
		
		for (int i = 0; i < users.size(); i++) {
			this.add(userNames.get(i));
			this.add(roles.get(i));
			this.add(checkBoxes.get(i));
		}
	}

	public List<JLabel> getUserNames() {
		return userNames;
	}

	public List<JComboBox<User.Role>> getRoles() {
		return roles;
	}

	public List<JCheckBox> getCheckBoxes() {
		return checkBoxes;
	}
}

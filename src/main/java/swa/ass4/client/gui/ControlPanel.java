package swa.ass4.client.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.lang3.text.WordUtils;

import net.miginfocom.swing.MigLayout;
import swa.ass4.domain.User;

public abstract class ControlPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected ControlPanel(User user) {
		this.setLayout(new MigLayout("wrap 1, fill"));
		this.setSize(300, 300);   
	    this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(WordUtils.capitalizeFully(user.getRole().toString()) + " Control Panel");
		
	    this.add(new JLabel(user.getFirstName() + " " + user.getLastName() + " (" + user.getUserName() + ")"));
	}

	public static ControlPanel getInstance(User user, WebTarget target) {
		switch (user.getRole()) {
		case ADMINISTRATOR:
			return new AdminControlPanel(user, target);
		case STUDENT:
			return new StudentControlPanel(user, target);
		case TEACHER:
			return new TeacherControlPanel(user, target);
		default:
			throw new RuntimeException("Could not determine user role");
		}
	}

}

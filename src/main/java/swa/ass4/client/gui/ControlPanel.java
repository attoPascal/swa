package swa.ass4.client.gui;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import swa.ass4.domain.User;

public abstract class ControlPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected ControlPanel() {
		this.setLayout(new MigLayout("wrap 1, fill"));
		this.setSize(320, 200);   
	    this.setResizable(false);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static ControlPanel getInstance(User user) {
		switch (user.getRole()) {
		case ADMINISTRATOR:
			return null;
		case STUDENT:
			return new StudentControlPanel();
		case TEACHER:
			return null;
		default:
			throw new RuntimeException("Could not determine user role");
		}
	}

}

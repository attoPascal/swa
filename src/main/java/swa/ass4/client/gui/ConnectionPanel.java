package swa.ass4.client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ConnectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_URL  = "localhost";
	private static final String DEFAULT_PORT = "9000";
	
	private JTextField urlField;
	private JTextField portField;
	
	public ConnectionPanel() {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		urlField  = new JTextField(DEFAULT_URL);
		portField = new JTextField(DEFAULT_PORT);
	    
	    this.add(new JLabel("URL"));
	    this.add(urlField, "growx");
	    
	    this.add(new JLabel("Port"));
	    this.add(portField, "");
	}
	
	public String getConnectionURL() {
		return "http://" + urlField.getText() + ":" + portField.getText();
	}
}

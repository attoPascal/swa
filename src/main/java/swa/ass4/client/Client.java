package swa.ass4.client;

import swa.ass4.client.gui.LoginGUI;

public class Client {
	Client instance = null;
	
	private Client() {}
	
	public Client getInstance() {
		if (instance == null) {
			return instance = new Client();
		} else {
			return instance;
		}
	}
	
	public static void main(String[] args) {
		LoginGUI gui = new LoginGUI() ;
	}
}

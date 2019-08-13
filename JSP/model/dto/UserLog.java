package dto;

public class UserLog {

	private String nick;
	private String pass;
	
	public UserLog(String nick, String pass) {
		this.nick = nick;
		this.pass = pass;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
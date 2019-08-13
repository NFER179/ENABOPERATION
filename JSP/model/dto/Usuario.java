package dto;

public class Usuario {

	private String nick;
	private String name;
	private String email;
	private String pass;
	
	public Usuario(String nick, String name, String email, String pass) {
		super();
		this.nick = nick;
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
}
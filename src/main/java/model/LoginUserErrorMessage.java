package model;

public class LoginUserErrorMessage {
	private final String name;
	private final String pass;

	public LoginUserErrorMessage() {
		throw new IllegalArgumentException("\n【警告】引数にnameとpassを指定してください");
	}

	public LoginUserErrorMessage(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

}

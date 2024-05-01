package model;

public class RegistUserErrorMsg {
	private final String name;
	private final String pass;

	 public RegistUserErrorMsg() {
		throw new IllegalArgumentException("\n【警告】引数にnameとpassを指定してください");
	}

	

	public RegistUserErrorMsg(String name, String pass) {
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
